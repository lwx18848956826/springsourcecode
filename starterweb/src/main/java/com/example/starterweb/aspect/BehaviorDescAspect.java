package com.example.starterweb.aspect;

import com.example.starterweb.annotation.BehaviorDesc;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author John Lee
 * @Version
 * @Description
 * @date 2020/6/12 20:11
 */
@Order(0)
@Aspect
@Component
@Slf4j
public class BehaviorDescAspect {

    @Pointcut("@annotation(com.example.starterweb.annotation.BehaviorDesc)")
    public void aspect(){}

    @Around("aspect()")
    public Object Interceptor(ProceedingJoinPoint pjp){

        log.info("行为描述-Around start");
        Object result = null;
        try {
            //放行到before方法
            result = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        log.info("行为描述-Around end");
        return result;
    }

    /**
     * 当想获得注解里面的属性,可以直接注入该注解,进行get方法即可
     * @param behaviorDesc
     */
    @Before("aspect() && @annotation(behaviorDesc)")
    public void before(BehaviorDesc behaviorDesc){
        String value = behaviorDesc.value();
        log.info("行为描述-before: value=" + value);
    }

    @After("aspect() && @annotation(behaviorDesc)")
    public void after(BehaviorDesc behaviorDesc){
        String value = behaviorDesc.value();
        log.info("行为描述-after: value=" + value);
    }
}
