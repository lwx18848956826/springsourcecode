package com.study.controller;

import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/22 11:49
 */
public class HttpController implements Controller {
    public void doHttpHandler() {
        System.out.println("Http...");
    }
   /* @Override
    public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        //给Request设置值，在页面进行回显
        httpServletRequest.setAttribute("hello", "这是HttpRequestHandler！");
        //跳转页面
        httpServletRequest.getRequestDispatcher("/WEB-INF/jsps/index.jsp").forward(httpServletRequest, httpServletResponse);

    }*/
}
