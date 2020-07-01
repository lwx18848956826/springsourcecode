package com.spring.ioc.test;

import com.spring.ioc.context.SpringContext;
import com.spring.ioc.service.IUserService;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/17 16:15
 */
public class SpringIocTest {

    public static void main(String[] args) throws Exception {
        String path = "com.spring.ioc.service";
        SpringContext context = new SpringContext(path);
        IUserService userService = (IUserService) context.getBean("userbiz");
        System.out.println(userService.findOrder("lyl"));

    }
}
