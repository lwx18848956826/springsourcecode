package com.spring.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/17 18:28
 */
public class ServletDemo implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().println("Hello ServletDemo!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
