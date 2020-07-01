package com.spring.ioc.annotation;

import java.lang.annotation.*;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/17 16:01
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface IocService {
    String name() default "";
}
