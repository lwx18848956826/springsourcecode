package com.study.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/19 17:35
 */
public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("调用BeanPostProcessor的postProcessBeforeInitialization()方法");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("调用BeanPostProcessor的postProcessAfterInitialization()方法");
        return bean;
    }
}
