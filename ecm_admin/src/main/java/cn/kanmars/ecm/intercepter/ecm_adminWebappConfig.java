package cn.kanmars.ecm.intercepter;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by baolong on 2016/12/15.
 */
@Service
public class ecm_adminWebappConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        SessionInterceptor si = new SessionInterceptor();
        //设置不需要拦截的地址
        si.setAllowUrls(new String[]{"/login/login.dhtml", "/login/loginCheck.dhtml", "/login/logout.dhtml", "/login/auth.dhtml", "/login/ecm.dhtml", "/login/isLogin.dhtml"});
        registry.addInterceptor(si).addPathPatterns("/**/*.dhtml");

        //可以添加多个Interceptor
        //......
    }
}
