package com.study.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/19 18:15
 */
public class AccountAdvice {

    /** 前置增强 */
    public void myBefore(JoinPoint joinPoint){
        before();
    }

    /** 后置增强 */
    public void myAfter(JoinPoint joinPoint) {
        after();
    }

    /** 环绕增强 */
    public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable{
        before();
        Object result  = joinPoint.proceed();
        after();
        return result;
    }

    /** 抛出异常增强 */
    public void myThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("抛出异常增强： " + e.getMessage());
    }


    private void before() {
        System.out.println("Before");
    }

    private void after(){
        System.out.println("After");
    }

}
