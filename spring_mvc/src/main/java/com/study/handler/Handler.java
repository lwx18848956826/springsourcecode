package com.study.handler;

import java.lang.reflect.Method;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/23 11:37
 */
public class Handler {

    /**
     * Controller 类
     */
    private Class<?> controllerClass;

    /**
     * Controller 方法
     */
    private Method controllerMethod;

    public Handler(Class<?> controllerClass, Method controllerMethod) {
        this.controllerClass = controllerClass;
        this.controllerMethod = controllerMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getControllerMethod() {
        return controllerMethod;
    }
}
