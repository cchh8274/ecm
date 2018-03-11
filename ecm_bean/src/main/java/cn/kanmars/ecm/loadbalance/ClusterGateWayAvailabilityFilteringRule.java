package cn.kanmars.ecm.loadbalance;

import cn.com.xbase.frame.util.PropertiesUtils;
import cn.com.xbase.frame.util.ServerInfoUtils;
import cn.com.xbase.frame.util.StringUtils;
import cn.kanmars.ecm.aspect.ClusterTrack;
import com.netflix.loadbalancer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义路由功能,通过在application.properties中增加配置，以实现路由功能
 * Created by kanmars on 2017/8/22.
 */
public class ClusterGateWayAvailabilityFilteringRule extends AvailabilityFilteringRule {

    private static Logger log = LoggerFactory.getLogger(ClusterGateWayAvailabilityFilteringRule.class);
    private AbstractServerPredicate predicate;

    class RouteEntry implements Comparable{
        private String sourceIp;
        private String routeMode;
        private List<String> value;

        public RouteEntry(String sourceIp, String routeMode, List<String> value) {
            this.sourceIp = sourceIp;
            this.routeMode = routeMode;
            this.value = value;
        }

        public String getSourceIp() {
            return sourceIp;
        }

        public void setSourceIp(String sourceIp) {
            this.sourceIp = sourceIp;
        }

        public String getRouteMode() {
            return routeMode;
        }

        public void setRouteMode(String routeMode) {
            this.routeMode = routeMode;
        }

        public List<String> getValue() {
            return value;
        }

        public void setValue(List<String> value) {
            this.value = value;
        }

        @Override
        public int compareTo(Object o) {
            return sourceIp.compareTo(((RouteEntry)o).getSourceIp());
        }

        @Override
        public String toString() {
            return "RouteEntry{" +
                    "sourceIp='" + sourceIp + '\'' +
                    ", routeMode='" + routeMode + '\'' +
                    ", value=" + value +
                    '}';
        }
    }

    private AtomicInteger nextServerCyclicCounter;

    public ClusterGateWayAvailabilityFilteringRule(){
        super();
        predicate = CompositePredicate.withPredicate(new AvailabilityPredicate(this, null))
                .addFallbackPredicate(AbstractServerPredicate.alwaysTrue())
                .build();
        nextServerCyclicCounter = new AtomicInteger(0);
    }

    /**
     * 将 gatewayavailabilityfilteringrule=10.126.53.194::soft::10.126.53.196:10,10.126.53.197:10;10.126.[1-25].*::hard::10.126.53.196:10,10.126.53.197:10;
     * 这样的字符串，解析到propertiesInfo中，且按照:无*>无[]>有[]>有*的进行排序
     *
     */
    public List<RouteEntry> parseRouters(){
        List<RouteEntry> propertiesInfo = new ArrayList<RouteEntry>();
        //刷新配置properties
        String properties = "";
        String clusterTrack = ClusterTrack.getClusterTrack();
        if(StringUtils.isNotEmpty(clusterTrack)){
            //如果有集群属性，则根据集群属性寻找配置
            try{
                properties = PropertiesUtils.getString("application.properties","ribbon.GateWayAvailabilityFilteringRuleRoute."+clusterTrack);
            }catch (Exception e){
                properties = "";
            }
        }else{
            try{
                properties = PropertiesUtils.getString("application.properties","ribbon.GateWayAvailabilityFilteringRuleRoute");
            }catch (Exception e){
                properties = "";
            }
        }

        for(String propertie : properties.split(";")){
            String [] infos = propertie.split("::");
            if(infos.length!=3){
                log.error("GateWayAvailabilityFilteringRule解析配置不正确["+propertie+"]");
                continue;
            }
            String sourceIp = infos[0];
            String gatewaymode = infos[1];
            String targetIps = infos[2];

            List list = new ArrayList();
            for(String targetIp : targetIps.split(",")){
                list.add(targetIp);
            }
            propertiesInfo.add(new RouteEntry(sourceIp,gatewaymode,list));
        }
        //排序
        Collections.sort(propertiesInfo, new Comparator<RouteEntry>() {
            @Override
            public int compare(RouteEntry o1, RouteEntry o2) {
                //排序规则：根据sourceIp排序，
                //无*>无[]>有[]>有*的进行排序
                String sourceIp1 = o1.getSourceIp();
                String sourceIp2 = o2.getSourceIp();
                int i1 = 1;
                int i2 = 1;
                if(sourceIp1.contains("*")){//*加权为20
                    i1 *=20;
                }
                if(sourceIp1.contains("[")){//[加权为10
                    i1 *=10;
                }
                if(sourceIp2.contains("*")){
                    i2 *=20;
                }
                if(sourceIp2.contains("[")){
                    i2 *=10;
                }
                if(i1!=i2){
                    return i1-i2;
                }
                return sourceIp1.compareTo(sourceIp2);
            }
        });
        return propertiesInfo;
    }


    @Override
    public Server choose(Object key) {
        Server server = null;
        int count =0;
        while (server == null && count++ < 10) {
            List<Server> reachableServers = this.getLoadBalancer().getReachableServers();
            List<Server> allServers = this.getLoadBalancer().getAllServers();
            //刷新路由表
            List<RouteEntry> propertiesInfo = parseRouters();
            //根据权重算法重置server列表
            reachableServers = processWithWeight(propertiesInfo,reachableServers);
            //根据权重算法重置server列表
            allServers = processWithWeight(propertiesInfo,allServers);

            int upCount = reachableServers.size();
            int serverCount = allServers.size();

            if ((upCount == 0) || (serverCount == 0)) {
                return null;
            }

            int nextServerIndex = incrementAndGetModulo(serverCount);
            server = allServers.get(nextServerIndex);

            if (server == null) {
                /* Transient. */
                Thread.yield();
                continue;
            }

            if (server.isAlive() && (server.isReadyToServe()) && predicate.apply(new PredicateKey(server))) {
                return (server);
            }
            server = null;
        }

        if (count >= 10) {
            log.warn("No available alive servers after 10 tries from load balancer: " + this.getLoadBalancer());
        }
        if(server!=null){
            return server;
        }
        return super.choose(key);
    }

    private int incrementAndGetModulo(int modulo) {
        for (;;) {
            int current = nextServerCyclicCounter.get();
            int next = (current + 1) % modulo;
            if (nextServerCyclicCounter.compareAndSet(current, next))
                return next;
        }
    }

    /**
     * 设置server的权重配置
     * @param servers
     * @return
     */
    private List<Server> processWithWeight(List<RouteEntry> propertiesInfo,List<Server> servers){
        List<Server> result = new ArrayList<Server>();
        String ip = ServerInfoUtils.getIp();
        //propertiesInfo为已排序的数据
        boolean isMatch = false;
        for(RouteEntry e : propertiesInfo){
            String sourceIp = e.getSourceIp();
            String routeMode = e.getRouteMode();
            List<String> value = e.getValue();
            //[]和*的解析
            if(matchIp(ip,sourceIp)){
                isMatch = true;
                //如果当前IP符合规则
                if(routeMode.equalsIgnoreCase("soft")){
                    //soft模式，则先加入serverList，然后再按照route的规则增加
                    result.addAll(servers);
                }else{
                    //非soft则为hard模式，不添加原serverList
                }
                //根据权重扩充server
                for(Server s : servers){
                    String ip_server = s.getHost();
                    for(String ip_and_weight : value){
                        String ipRegex = ip_and_weight.split(":")[0];
                        int weight = Integer.parseInt(ip_and_weight.split(":")[1]);
                        if(matchIp(ip_server,ipRegex)){
                            //如果匹配，按照权重添加server
                            for(int i = 0 ;i<weight;i++){
                                result.add(s);
                            }
                        }
                    }
                }
            }
        }
        if(!isMatch){
            //如果没有匹配上
            result.addAll(servers);
        }
        return result;
    }

    public static boolean matchIp(String ip,String ipRegex){
        boolean result = true;
        String[] nets_source = ipRegex.split("\\.");
        String[] nets_current = ip.split("\\.");
        int i=0;
        for(i=0;i<=3;i++){
            if(nets_source[i].trim().equals(nets_current[i].trim())){
                continue;
            }
            if(nets_source[i].trim().equals("*")){
                continue;
            }
            if(nets_source[i].contains("[")){
                String net_from_to = nets_source[i].replace("[","").replace("]","");
                int from = Integer.parseInt(net_from_to.split("-")[0].trim());
                int to = Integer.parseInt(net_from_to.split("-")[1].trim());
                int curr = Integer.parseInt(nets_current[i].trim());
                if(curr>= from && curr <=to){
                    continue;
                }else{
                    result = false;
                    break;
                }
            }
            result = false;
            break;
        }
        if(i==4&&result){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(matchIp("10.126.54.196","10.*.*.*"));
        System.out.println(matchIp("10.126.54.196","11.*.*.*"));
        System.out.println(matchIp("10.126.54.196","10.126.*.*"));
        System.out.println(matchIp("10.126.54.196","10.127.*.*"));
        System.out.println(matchIp("10.126.54.196","10.126.[10-54].*"));
        System.out.println(matchIp("10.126.54.196","10.126.[55-198].*"));
        System.out.println(matchIp("10.126.54.196","10.126.[10-54].196"));
        System.out.println(matchIp("10.126.54.196","10.126.[10-54].[0-255]"));
        System.out.println(matchIp("10.126.54.196","10.*.[10-54].[0-255]"));
    }
}
