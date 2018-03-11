package cn.kanmars.ecm.feign;

import cn.com.xbase.frame.logger.ExPatternParser;
import cn.kanmars.ecm.aspect.RequestTrackAspect;
import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * 请求拦截器，发起新请求时，将一些信息写入head域中
 * 使用场景:ecm-admin,ecm-service,ecm-web,ecm-task等应用发出请求时，用于请求追踪
 * Created by baolong on 2017/1/10.
 */
public class RequestTrackInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        String threadNumber = ExPatternParser.ThreadNumber.getThreadNumber();
        //需要注意Feign使用的是请求模版技术，此参数设置设置于模版中，在最终调用RequestTemplate.request()方法时才会生效
        template.header(RequestTrackAspect.REQUESTTRACK, threadNumber);
    }
}
