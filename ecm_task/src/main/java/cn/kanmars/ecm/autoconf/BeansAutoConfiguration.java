package cn.kanmars.ecm.autoconf;

import cn.com.xbase.frame.util.SpringBeanFactory;
import cn.kanmars.ecm.aspect.OperationLogAspect;
import cn.kanmars.ecm.controller.LoggerController;
import cn.kanmars.ecm.feign.ClusterTrackInterceptor;
import cn.kanmars.ecm.feign.RequestTrackInterceptor;
import cn.kanmars.ecm.feign.SecurityRequestInterceptor;
import cn.kanmars.ecm.util.SysDicUtils;
import cn.kanmars.ecm.util.SysSequenceUtils;
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

    @Bean("operationLogAspect")
    public OperationLogAspect getOperationLogAspect(){
        //日志切面
        OperationLogAspect operationLogAspect = new OperationLogAspect();
        return operationLogAspect;
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

    @Bean("loggerController")
    public LoggerController getLoggerController(){
        LoggerController loggerController = new LoggerController();
        return loggerController;
    }

    @Bean("springBeanFactory")
    public SpringBeanFactory getSpringBeanFactory(){
        SpringBeanFactory springBeanFactory = new SpringBeanFactory();
        return springBeanFactory;
    }
}
