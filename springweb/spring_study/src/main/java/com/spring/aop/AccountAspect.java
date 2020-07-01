package com.spring.aop;

import java.lang.reflect.Method;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/24 13:58
 */
public class AccountAspect extends BaseAspect {


    /**
     * 切入点
     */
    @Override
    public boolean isInterceptor(Method method, Object[] args) {

        return method.getName().equals("transfer");
    }

    @Override
    public void before() {
        System.out.println("对转账人身份进行验证.");
    }
}