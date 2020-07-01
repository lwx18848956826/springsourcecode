package com.example.starterweb.annotation;

import com.example.starterweb.config.datasource.DataSourceType;

import java.lang.annotation.*;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/15 10:44
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DataSource {
    DataSourceType value() default DataSourceType.MASTER;
}
