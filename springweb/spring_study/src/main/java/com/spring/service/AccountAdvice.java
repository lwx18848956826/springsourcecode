package com.spring.service;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/24 11:39
 */
public class AccountAdvice implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        before();
        return methodProxy.invokeSuper(obj, args);
//        return method.invoke(obj,args);
    }

    private void before() {
        System.out.println("对转账人身份进行验证.");
    }
}
