package cn.kanmars.ecm.feign;

import cn.com.xbase.frame.util.StringUtils;
import cn.kanmars.ecm.aspect.ClusterTrack;
import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * 请求拦截器，发起新请求时，将一些信息写入head域中
 * 使用场景:ecm-admin,ecm-service,ecm-web,ecm-task等应用发出请求时，用于集群追踪
 * Created by kanmars on 2017/8/22.
 */
public class ClusterTrackInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        String clusterTrack = ClusterTrack.getClusterTrack();
        if(StringUtils.isNotEmpty(clusterTrack)){
            //需要注意Feign使用的是请求模版技术，此参数设置设置于模版中，在最终调用RequestTemplate.request()方法时才会生效
            template.header(ClusterTrack.CLUSTERTRACK, clusterTrack);
        }
    }
}
