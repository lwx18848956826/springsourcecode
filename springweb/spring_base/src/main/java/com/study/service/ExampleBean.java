package com.study.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/19 17:46
 */
@Component("exampleBean")
@Scope("prototype")
public class ExampleBean {

    @PostConstruct
    public void init() {
        System.out.println("初始化方法");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("销毁方法");
    }

}
