package cn.kanmars.ecm.filter;

import cn.com.xbase.frame.filter.SqlAttackFilter;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;

/**
 * Created by baolong on 2017/1/13.
 */
@WebFilter(urlPatterns="*.dhtml")
public class WebSqlAttackFilter extends SqlAttackFilter {
    public void init(FilterConfig filterConfig) throws ServletException {
        init("/500.html","请求参数中包含特殊字符！","[^%'=;]{1,}",new String[]{"insert","update","delete"});
    }
}
