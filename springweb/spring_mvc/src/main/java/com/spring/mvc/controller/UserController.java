package com.spring.mvc.controller;


import com.spring.mvc.domain.User;
import com.spring.mvc.service.IUserService;
import com.spring.mvc.view.View;
import com.study.annotation.Autowired;
import com.study.annotation.Controller;
import com.study.annotation.RequestMapping;
import com.study.enums.RequestMethod;

import java.util.List;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/23 15:40
 */
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 用户列表
     * @return
     */
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public View getUserList() {
        List<User> userList = userService.getAllUser();
        return new View("index.jsp").addView("userList", userList);
    }

}
