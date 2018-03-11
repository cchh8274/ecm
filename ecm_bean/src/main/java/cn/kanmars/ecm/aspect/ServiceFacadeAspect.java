package cn.kanmars.ecm.aspect;

import cn.com.xbase.frame.logger.HLogger;
import cn.com.xbase.frame.logger.LoggerManager;
import cn.com.xbase.frame.util.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by baolong on 2016/12/19.
 * 使用场景:ecm-service的服务公用报错切面
 */
@Aspect
@Order(-20)
@Component
public class ServiceFacadeAspect {

    private HLogger logger = LoggerManager.getLoger("ServiceFacadeAspect");

    @Pointcut("execution(public * cn.kanmars.ecm.service..*.*(..))")
    public Object serviceMethod(){
        return null;
    }

    @Around("serviceMethod()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            logger.error("运行时发生异常", throwable);
            HashMap result = new HashMap();
            String message = StringUtils.truncateString(throwable.getMessage(),100);
            result.put("resCode","0002");
            result.put("resDesc", "发生异常["+message+"]");
            return result;
        }
    }
}
