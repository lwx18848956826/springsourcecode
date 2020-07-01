package com.spring.mvc.service;


import com.spring.mvc.domain.User;
import com.study.annotation.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description 获取所有用户
 * @date 2020/6/23 15:37
 */
@Service
public class UserService implements IUserService {

    /**
     * 获取所有用户
     * @return
     */
    @Override
    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Tom", 22));
        userList.add(new User(2, "Alic", 12));
        userList.add(new User(3, "Bob", 32));
        return userList;

    }
}
