package com.example.starterweb.controller;

import com.example.starterweb.domain.TUser;
import com.example.starterweb.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/15 10:57
 */
@RestController
public class DataSourceController {

    @Resource
    private UserService userService;

    @RequestMapping("/insert1")
    public Integer insert01(String name, Integer age) {

        return userService.insertUser1(name, age);
    }

    @RequestMapping("/user")
    public TUser findUserByName(String name) {
        return userService.findByName(name);
    }

    @RequestMapping("/insert2")
    public Integer insert02(String name, Integer age) {

        return userService.insertUser2(name, age);
    }
}
