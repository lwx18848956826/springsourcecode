package com.example.starterweb.annotation;

import java.lang.annotation.*;

/**
 * @author John Lee
 * @Version
 * @Description
 * @date 2020/6/12 20:04
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Authentication {
}
