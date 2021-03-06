package cn.kanmars.ecm.autoconf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.HashMap;

/**
 * Created by baolong on 2016/12/15.
 */
@Configuration
public class FreeMarkerViewResolverAutoConfiguration {
    @Bean
    public FreeMarkerViewResolver createFreeMarkerViewResolver(){
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setAllowRequestOverride(false);
        freeMarkerViewResolver.setSuffix(".ftl");
        freeMarkerViewResolver.setContentType("text/html;charset=UTF-8");
        freeMarkerViewResolver.setExposeRequestAttributes(true);
        freeMarkerViewResolver.setRequestContextAttribute("request");
        freeMarkerViewResolver.setOrder(0);
        freeMarkerViewResolver.setAttributesMap(new HashMap<String, Object>(){{
            this.put("ddt",   new cn.com.xbase.frame.template.DataDictionaryTemplate());
            this.put("dft",   new cn.com.xbase.frame.template.DateFormatTemplate());
            this.put("mft",   new cn.com.xbase.frame.template.MoneyFormatTemplate());
            this.put("sft",   new cn.com.xbase.frame.template.StringFormatTemplate());
            this.put("props", new cn.com.xbase.frame.template.PropsConfigTemplate());
        }});
        return freeMarkerViewResolver;
    }
}
