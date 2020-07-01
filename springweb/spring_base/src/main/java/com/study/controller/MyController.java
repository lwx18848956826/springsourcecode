package com.study.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/22 10:46
 */
public class MyController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hello","欢迎学习spring mvc!!!");
//        modelAndView.setViewName("/WEB-INF/jsps/index");
        modelAndView.setViewName("index");
//        modelAndView.setView(View);
        return modelAndView;
    }
}
