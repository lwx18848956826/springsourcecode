package com.study.handler.impl;

import com.study.controller.AnnotationController;
import com.study.handler.HandlerAdapter;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/22 11:55
 */
public class AnnotationHandlerAdapter implements HandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof AnnotationController);
    }

    @Override
    public void handle(Object handler) {
        ((AnnotationController)handler).doAnnotationHandler();
    }
}
