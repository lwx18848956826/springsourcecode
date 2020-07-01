package com.spring.mvc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/23 17:09
 */
@WebFilter("/*")
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse resp=(HttpServletResponse)response;
        System.out.println("过滤器中的PathInfo:"+req.getPathInfo());
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
