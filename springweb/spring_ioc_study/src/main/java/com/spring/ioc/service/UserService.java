package com.spring.ioc.service;

import com.spring.ioc.annotation.IocResource;
import com.spring.ioc.annotation.IocService;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/17 16:06
 */
@IocService(name = "userbiz")
public class UserService implements IUserService {



    /** 比较脆弱啊 这块的属性名称一定要用实现类来命名 且 按照第一个字母要小写的原则 否则很报错的*/
    @IocResource
    private IOrderService orderServiceImpl;

    @Override
    public String findOrder(String username) {
        return orderServiceImpl.findOrder(username);
    }



}
