package cn.kanmars.ecm;

import cn.kanmars.ecm.dyndata.DynamicDataSourceRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by baolong on 2016/12/22.
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableDiscoveryClient
@EnableFeignClients
@ServletComponentScan
@ComponentScan(basePackages = {"cn.kanmars.ecm"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
@Import(DynamicDataSourceRegister.class)
public class TaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }
}
