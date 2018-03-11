package cn.kanmars.ecm;

import feign.Feign;
import feign.Param;
import feign.RequestLine;
import feign.codec.Decoder;
import feign.codec.StringDecoder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.support.SpringDecoder;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;

import java.util.List;

/**
 * 该类用于直接使用Feign方式调用服务器端数据，同时支持HTTP与HTTPS
 * Created by baolong on 2017/2/8.
 */
public class FeignServiceTest {

    interface FeignClientInterface {
        @RequestLine("GET /s?wd={wd}&idx={idx}")
        String contributors(@Param("wd") String wd,@Param("idx") String idx);
    }

    public static void main(String... args) {
        //解码器
        SpringDecoder sd = new SpringDecoder(new ObjectFactory<HttpMessageConverters>() {
            @Override
            public HttpMessageConverters getObject() throws BeansException {
                return new HttpMessageConverters();
            }
        });
        //编码器
        SpringEncoder se = new SpringEncoder(new ObjectFactory<HttpMessageConverters>() {
            @Override
            public HttpMessageConverters getObject() throws BeansException {
                return new HttpMessageConverters();
            }
        });
        FeignClientInterface feignClient = Feign.builder()
                .encoder(se)
                .decoder(sd)
                .target(FeignClientInterface.class, "https://www.baidu.com");

        // Fetch and print a list of the contributors to this library.
        String result = feignClient.contributors("aaa","ccc");
        System.out.println(result);
    }
}
