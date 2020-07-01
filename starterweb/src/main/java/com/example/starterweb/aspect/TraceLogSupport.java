package com.example.starterweb.aspect;

import com.alibaba.fastjson.JSON;
import com.example.starterweb.annotation.TraceLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/12 19:30
 */
@Aspect
@Component
@Slf4j
public class TraceLogSupport {

    @Pointcut("@annotation(com.example.starterweb.annotation.TraceLog)")
    private void pointcut() {

    }

    @Before("pointcut()&&@annotation(traceLog)")
    public void before(JoinPoint joinPoint, TraceLog traceLog) {
        Object[] args = joinPoint.getArgs();
        log.error(generateLog(traceLog, JSON.toJSONString(args)));
    }

    private String generateLog(TraceLog traceLog, String args) {
        List<String> elements = new ArrayList<>();
        elements.add(traceLog.business());
        elements.add(traceLog.module());
        elements.add(args);
        return String.join(";", elements);
    }
}
