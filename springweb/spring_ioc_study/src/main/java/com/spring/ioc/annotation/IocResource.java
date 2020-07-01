package com.spring.ioc.annotation;

import java.lang.annotation.*;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/17 16:03
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IocResource {
}
