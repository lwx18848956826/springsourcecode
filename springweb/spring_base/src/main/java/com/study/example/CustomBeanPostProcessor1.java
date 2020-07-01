package com.study.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/19 17:27
 */
public class CustomBeanPostProcessor1 implements BeanPostProcessor, Ordered {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean执行init()方法之前的定制逻辑1.");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean执行init()方法之后的定制逻辑1.");
        return bean;
    }


    @Override
    public int getOrder() {
        return 0;
    }
}
