package com.study.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/19 19:22
 */
@Component
@Aspect
public class AccountAspect {

    /** 切入点 */
    @Pointcut("execution(* com.study.service.impl.AccountServiceImpl.*(..))")
    private void pointCut(){};

    /** 前置增强 */
    @Before("pointCut()")
    public void myBefore(JoinPoint joinPoint){
        before();
    }

    /** 后置增强 */
    @After("pointCut()")
    public void myAfter(JoinPoint joinPoint) {
        after();
    }

    /** 环绕增强 */
    @Around("pointCut()")
    public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable{
        before();
        Object result  = joinPoint.proceed();
        after();
        return result;
    }

    /** 抛出异常增强 */
    @AfterThrowing(value = "pointCut()", throwing = "e")
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
