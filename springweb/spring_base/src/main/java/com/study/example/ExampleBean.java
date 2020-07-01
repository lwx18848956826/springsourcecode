package com.study.example;

import com.study.cycle.SmartLifecycle;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/19 17:01
 */
public class ExampleBean implements InitializingBean, DisposableBean, SmartLifecycle, BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    private boolean isRunning = false;

    public void init() {
        System.out.println("调用xml配置的初始化方法");
    }

    @Override
    public void destroy() {
        System.out.println("调用xml配置的销毁方法");
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable runnable) {
        runnable.run();
        System.out.println("容器关闭.");
    }

    @Override
    public void start() {
        isRunning = true;
        System.out.println("容器启动.");
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public int getPhase() {
        return -1;
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("调用BeanNameAware的setBeanName()方法");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("调用ApplicationContext的setApplicationContext()方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean的afterPropertiesSet()方法");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware的setBeanFactory()方法");
    }

    public void sayHello() {
        System.out.println("bean可以使用了.");
    }
}
