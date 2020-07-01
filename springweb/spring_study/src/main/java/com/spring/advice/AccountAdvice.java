package com.spring.advice;

import com.spring.service.IAccountService;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/24 11:35
 */
public class AccountAdvice implements InvocationHandler {

    /** 目标对象 */
    private IAccountService target;

    public AccountAdvice(IAccountService target) {
        this.target = target;
    }



    /**
     * 前置增强
     */
    private void before() {
        System.out.println("对转账人身份进行验证.");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        return method.invoke(proxy,args);
    }
}
