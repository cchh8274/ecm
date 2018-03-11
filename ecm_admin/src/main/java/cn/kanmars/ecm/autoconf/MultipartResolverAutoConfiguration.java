package cn.kanmars.ecm.autoconf;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.MultipartConfigElement;

/**
 * Created by baolong on 2016/12/15.
 */
@Configuration
public class MultipartResolverAutoConfiguration {

//    /**
//     * 文件上传解析器，在标准SpringMVC中有作用，但是在SpringBoot项目中无效，并且会导致file无法解析的问题
//     * @return
//     */
//    @Bean
//    @ConditionalOnClass({CommonsMultipartResolver.class})
//    public CommonsMultipartResolver createCommonsMultipartResolver(){
//        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
//        commonsMultipartResolver.setDefaultEncoding("UTF-8");
//        commonsMultipartResolver.setResolveLazily(true);//resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
//        commonsMultipartResolver.setMaxInMemorySize(40960);//bytes
//        commonsMultipartResolver.setMaxUploadSize(50*1024*1024);//上传文件大小 50M 50*1024*1024
//        return commonsMultipartResolver;
//    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //// 设置文件大小限制 ,超了，页面会抛出异常信息，这时候就需要进行异常信息的处理了;
        factory.setMaxFileSize("2MB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("10MB");
        //Sets the directory location where files will be stored.
        //factory.setLocation("路径地址");
        return factory.createMultipartConfig();
    }
}
