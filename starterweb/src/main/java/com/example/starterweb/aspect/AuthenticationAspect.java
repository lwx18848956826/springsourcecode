package com.example.starterweb.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author John Lee
 * @Version
 * @Description AuthAspect - 权限校验
 * @date 2020/6/12 20:02
 */
@Order(-1)
@Aspect
@Component
@Slf4j
public class AuthenticationAspect {

    /**
     * @Pointcut 定义要拦截的注解, 第一种方式是只要加上该生效, 第二种是在指定包下加上注解才生效
     * 1.@Pointcut("@annotation(com.hllcve.customannotation.authentication.Authentication)")
     * 2.@Pointcut("execution(public * com.hllcve.customannotation.controller.*.*(..)) && " +
     * "@annotation(com.hllcve.customannotation.authentication.Authentication)")
     */
    @Pointcut("execution(public * com.example.starterweb.controller.*.*(..)) && " +
            "@annotation(com.example.starterweb.annotation.Authentication)")
    public void aspect() {
    }


    /**
     * 定制一个环绕通知
     *
     * @param pjp
     */
    @Around("aspect()")
    public Object Interceptor(ProceedingJoinPoint pjp) {

        log.info("权限校验-Around start");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        Object result = null;
        String role = request.getParameter("role");
        if (!"manager".equals(role)) {
            return "Insufficient permissions";
        }

        try {
            //放行到before方法
            result = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        log.info("权限校验-Around end");
        return result;
    }

    @Before("aspect()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        log.info("权限校验-before: arg=" + args[0]);
    }

    @After("aspect()")
    public void after(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        log.info("权限校验-after: arg=" + args[0]);
    }

}
