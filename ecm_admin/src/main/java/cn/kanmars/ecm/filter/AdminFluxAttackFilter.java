package cn.kanmars.ecm.filter;

import cn.com.xbase.frame.filter.FluxAttackFilter;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;

/**
 * Created by baolong on 2017/1/13.
 * 流量拦截攻击
 */
@WebFilter(urlPatterns="*.dhtml")
public class AdminFluxAttackFilter extends FluxAttackFilter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        /*无白名单版本*/
        init("/500.html", "访问次数过于频繁！","IP", 10000, 5 * 60 * 1000, 500);
        //有白名单版本
        //init("/500.html", "访问次数过于频繁！","IP", 10000, 5 * 60 * 1000, 500,new HashSet<String>(){{this.add("127.0.0.1");}});

    }
}
