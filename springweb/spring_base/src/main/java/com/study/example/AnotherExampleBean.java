package com.study.example;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/19 17:02
 */
public class AnotherExampleBean implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("do some initialization work.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("do some destruction  work.");
    }

    public void cleanup() {
        System.out.println("do some cleanup work.");
    }
}
