package com.example.starterweb.annotation;

import java.lang.annotation.*;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/12 19:29
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TraceLog {

    /**
     * 业务
     */
    String business();

    /**
     * 模块
     */
    String module();
}
