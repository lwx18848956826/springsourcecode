package com.spring.mvc.service;


import com.spring.mvc.domain.User;

import java.util.List;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/23 15:34
 */
public interface IUserService {
    List<User> getAllUser();
}
