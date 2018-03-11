package cn.kanmars.ecm.autoconf;

import cn.kanmars.ecm.aspect.ClusterTrackServiceAspect;
import cn.kanmars.ecm.aspect.OperationLogAspect;
import cn.kanmars.ecm.aspect.RequestTrackAspect;
import cn.kanmars.ecm.aspect.ServiceFacadeAspect;
import cn.kanmars.ecm.controller.LoggerController;
import cn.kanmars.ecm.feign.ClusterTrackInterceptor;
import cn.kanmars.ecm.feign.RequestTrackInterceptor;
import cn.kanmars.ecm.feign.SecurityRequestInterceptor;
import cn.kanmars.ecm.loadbalance.ClusterGateWayAvailabilityFilteringRule;
import cn.kanmars.ecm.util.SysDicUtils;
import cn.kanmars.ecm.util.SysSequenceUtils;
import com.netflix.loadbalancer.IRule;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by baolong on 2016/12/26.
 */
@Configuration
public class BeansAutoConfiguration implements ApplicationContextAware {

    ApplicationContext ac;

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        this.ac = ac;
    }

    @Bean("sysDicUtils")
    public SysDicUtils getSysDicUtils(){
        SysDicUtils sysDicUtils = new SysDicUtils();
        sysDicUtils.setApplicationContext(ac);
        return sysDicUtils;//返回后再根据@PostConstruct标签进行初始化
    }

    @Bean("sysSequenceUtils")
    public SysSequenceUtils getSysSequenceUtils(){
        SysSequenceUtils sysSequenceUtils = new SysSequenceUtils();
        sysSequenceUtils.setApplicationContext(ac);
        return sysSequenceUtils;//返回后再根据@PostConstruct标签进行初始化
    }

    @Bean("serviceFacadeAspect")
    public ServiceFacadeAspect getServiceFacadeAspect(){
        //所有服务在报错时，返回值为0002
        ServiceFacadeAspect serviceFacadeAspect = new ServiceFacadeAspect();
        return serviceFacadeAspect;
    }

    @Bean("requestTrackAspect")
    public RequestTrackAspect getRequestTrackAspect(){
        //请求跟踪切面，从请求中获取到head域中的REQUESTTRACK信息，然后存入本地线程号，处理完毕后移除
        RequestTrackAspect requestTrackAspect = new RequestTrackAspect();
        return requestTrackAspect;
    }

    @Bean("clusterTrackServiceAspect")
    public ClusterTrackServiceAspect getClusterTrackServiceAspect(){
        //集群跟踪切面，从请求中获取到head域中的CLUSTERTRACK信息，然后存入本地线程变量，处理完毕后移除
        ClusterTrackServiceAspect clusterTrackServiceAspect = new ClusterTrackServiceAspect();
        return clusterTrackServiceAspect;
    }

    @Bean("securityRequestInterceptor")
    public SecurityRequestInterceptor getSecurityRequestInterceptor(){
        //请求签名信息，用于生成请求时，附加签名信息，防止误调用
        SecurityRequestInterceptor securityRequestInterceptor = new SecurityRequestInterceptor();
        return securityRequestInterceptor;
    }

    @Bean("requestTrackInterceptor")
    public RequestTrackInterceptor getRequestTrackInterceptor(){
        //请求跟踪信息
        RequestTrackInterceptor requestTrackInterceptor = new RequestTrackInterceptor();
        return requestTrackInterceptor;
    }

    @Bean("clusterTrackInterceptor")
    public ClusterTrackInterceptor getClusterTrackInterceptor(){
        //请求跟踪信息
        ClusterTrackInterceptor clusterTrackInterceptor = new ClusterTrackInterceptor();
        return clusterTrackInterceptor;
    }

    @Bean("operationLogAspect")
    public OperationLogAspect getOperationLogAspect(){
        //日志切面
        OperationLogAspect operationLogAspect = new OperationLogAspect();
        return operationLogAspect;
    }

    @Bean("loggerController")
    public LoggerController getLoggerController(){
        LoggerController loggerController = new LoggerController();
        return loggerController;
    }

//    /**
//     * 用于支持自定义的路由负载均衡算法，客户端发起
//     * @return
//     */
//    @Bean("gateWayAvailabilityFilteringRule")
//    public IRule getGateWayAvailabilityFilteringRule(){
//        GateWayAvailabilityFilteringRule gateWayAvailabilityFilteringRule = new GateWayAvailabilityFilteringRule();
//        return gateWayAvailabilityFilteringRule;
//    }

    /**
     * 支持集群的路由负载均衡算法，客户端发起,在没有配置负载均衡配置时，默认轮询调用
     * @return
     */
    @Bean("clusterGateWayAvailabilityFilteringRule")
    public IRule getClusterGateWayAvailabilityFilteringRule(){
        ClusterGateWayAvailabilityFilteringRule clusterGateWayAvailabilityFilteringRule = new ClusterGateWayAvailabilityFilteringRule();
        return clusterGateWayAvailabilityFilteringRule;
    }
}
