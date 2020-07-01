package com.spring.aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/24 14:00
 */
public class ProxyFactory {

    public static <T> T createProxy(final Class<?> targetClass, final MethodInterceptor methodInterceptor){
        return (T) Enhancer.create(targetClass,methodInterceptor);
    }
}
