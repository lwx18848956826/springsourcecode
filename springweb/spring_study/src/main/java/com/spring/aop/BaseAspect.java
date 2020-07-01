package com.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/24 11:57
 */
public abstract class BaseAspect implements MethodInterceptor {


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        begin();
        try {
            if (isInterceptor(method, args)) {
                before();
                result = methodProxy.invokeSuper(obj, args);
                after();
            } else {
                result = methodProxy.invokeSuper(obj, args);
            }
        } catch (Exception e) {
            error(e);
            throw e;
        } finally {
            end();
        }
        return result;
    }


    /**
     * 开始增强
     */
    public void begin() {

    }

    /**
     * 前置增强
     */
    public void before() {

    }

    /**
     * 切入点判断
     */
    public boolean isInterceptor(Method method, Object[] args) {
        return true;
    }


    /**
     * 后置增强
     */
    public void after() {

    }

    /**
     * 异常增强
     */
    public void error(Exception e) {

    }


    /**
     * 最终增强
     */
    public void end() {

    }


}
