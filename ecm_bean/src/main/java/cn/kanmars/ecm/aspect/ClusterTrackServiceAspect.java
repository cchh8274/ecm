package cn.kanmars.ecm.aspect;

import cn.com.xbase.frame.logger.ExPatternParser;
import cn.com.xbase.frame.util.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * 集群跟踪切面,service专用，从请求中获取到head域中的CLUSTERTRACK信息，然后存入集群名称
 * 使用场景ecm-service中获取到请求，将请求中的CLUSTERTRACK信息设置入线程中
 * Created by kanmars on 2017/8/22.
 */
@Aspect
@Order(-90)//在日志之后，其他操作之前处理集群标识
public class ClusterTrackServiceAspect {


    @Pointcut("execution(public * cn.kanmars.ecm.service..*.*(..))")
    public Object serviceMethod() {
        return null;
    }

    @Around("serviceMethod()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //尝试从Request中获取clusterTrack并设置入ClusterTrack，此clusterTrack由ClusterTrackInterceptor设置完毕
        ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        if(request!=null){
            String clusterTrack = request.getHeader(ClusterTrack.CLUSTERTRACK);
            if(StringUtils.isNotEmpty(clusterTrack)){
                ClusterTrack.setClusterTrack(clusterTrack);
            }
        }
        Object returnValue = proceedingJoinPoint.proceed();
        return returnValue;
    }
}
