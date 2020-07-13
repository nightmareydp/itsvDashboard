package com.itsv.itsvdashboard.Filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.LogRecord;

/**
 * @Author yuduopeng
 * @date 2020/6/9
 * @time 20:17
 */

@Component
public class ContextFilter implements Filter {
    private final int time = 20*24*60*60;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        // 添加参数，允许任意domain访问

        resp.setHeader("Access-Control-Allow-Origin", "*");

        // 这个allow-headers要配为*，这样才能允许所有的请求头 --- update by zxy  in 2018-10-19

        resp.setHeader("Access-Control-Allow-Headers", "*");

        resp.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");

        resp.setHeader("Access-Control-Max-Age", time+"");

        filterChain.doFilter(servletRequest, resp);
    }

    @Override
    public void destroy() {

    }
}
