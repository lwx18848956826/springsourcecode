package com.example.starterweb.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/15 14:37
 */
@Target({java.lang.annotation.ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
//@Import({DynamicDataSourceRegister.class})
public @interface EnableDynamicDataSource {
}
