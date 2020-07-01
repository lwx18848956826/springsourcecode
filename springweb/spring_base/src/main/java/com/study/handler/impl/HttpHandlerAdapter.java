package com.study.handler.impl;

import com.study.controller.HttpController;
import com.study.handler.HandlerAdapter;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/22 11:54
 */
public class HttpHandlerAdapter implements HandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof HttpController);
    }

    @Override
    public void handle(Object handler) {
        ((HttpController)handler).doHttpHandler();
    }
}
