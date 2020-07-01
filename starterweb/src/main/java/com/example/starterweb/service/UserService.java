package com.example.starterweb.service;

import com.example.starterweb.annotation.DataSource;
import com.example.starterweb.config.datasource.DataSourceType;
import com.example.starterweb.dao.User2Mapper;
import com.example.starterweb.domain.TUser;
import com.example.starterweb.domain.User;
import com.example.starterweb.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/15 10:58
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private User2Mapper user2Mapper;

    @DataSource(DataSourceType.MASTER)
    @Transactional(rollbackFor = Exception.class)
    public TUser findByName(String name) {
        return user2Mapper.findByName(name);
    }

    @DataSource(DataSourceType.MASTER)
    @Transactional(rollbackFor = Exception.class)
    public int insertUser1(String name, Integer age) {
        int result = userMapper.insert(name, age);
        int i = 1 / age;
        return result;
    }

    @DataSource(DataSourceType.SLAVE)
    @Transactional(rollbackFor = Exception.class)
    public int insertUser2(String name, Integer age) {
        int result = userMapper.insert(name, age);
        int i = 1 / age;
        return result;
    }


}
