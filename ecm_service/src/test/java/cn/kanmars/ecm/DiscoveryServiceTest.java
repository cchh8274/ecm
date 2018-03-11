package cn.kanmars.ecm;

import cn.com.xbase.tools.eureka.EurekaTools;
import feign.Param;
import feign.RequestLine;
import java.util.List;

/**
 * 从eureka 中获取到服务，然后根据服务进行random调用。
 * Created by baolong on 2017/2/8.
 */
public class DiscoveryServiceTest {

//          使用该类，需要使用如下pom，默认情况下，在commons-rpc中会包含此包
//          <dependency>
//          <groupId>com.netflix.eureka</groupId>
//          <artifactId>eureka-client</artifactId>
//          <version>1.4.12</version>
//          </dependency>
//          <dependency>
//          <groupId>io.github.openfeign</groupId>
//          <artifactId>feign-core</artifactId>
//          <version>9.3.1</version>
//          </dependency>
//          <dependency>
//          <groupId>org.springframework.cloud</groupId>
//          <artifactId>spring-cloud-netflix-core</artifactId>
//          <version>1.2.3.RELEASE</version>
//          </dependency>
//          <dependency>
//          <groupId>com.thoughtworks.xstream</groupId>
//          <artifactId>xstream</artifactId>
//          <version>1.4.2</version>
//          </dependency>
//          <dependency>
//          <groupId>org.apache.httpcomponents</groupId>
//          <artifactId>httpclient</artifactId>
//          <version>4.5.2</version>
//          </dependency>

    /**
     * 模拟接口，需要按照业务自行设计
     */
    interface FeignClientInterface {
        @RequestLine("GET /mappings?wd={wd}&idx={idx}")
        String mappings(@Param("wd") String wd,@Param("idx") String idx);
    }


    public static void main(String[] args){
        try {
            //服务列表查询
            List<String> services = EurekaTools.getServiceUrls("http://10.58.56.33:9001/eureka/,http://10.58.56.33:9002/eureka/", "ecm-service");
            System.out.println("服务列表为："+services.toString());
            //调用某服务
            for(int i=0;i<100;i++){
                Object result = EurekaTools.invokeMethod("http://10.58.56.33:9001/eureka/,http://10.58.56.33:9002/eureka/",
                        "ecm-service",
                        FeignClientInterface.class,//feign定义
                        "mappings",//方法名称
                        new Class[]{String.class, String.class},//参数类型列表
                        new Object[]{"sss", "1"});//参数列表
                System.out.println(result);
            }
        }catch (Exception e){
            System.out.println("访问请求发生错误，返回的响应码不在[200-300)左闭右开区间，则报错!");
            e.printStackTrace();
        }
    }
}
