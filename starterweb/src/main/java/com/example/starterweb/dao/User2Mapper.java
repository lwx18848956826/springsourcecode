package com.example.starterweb.dao;

import com.example.starterweb.domain.TUser;
import com.example.starterweb.domain.User;
import com.example.starterweb.gener.CustomizeMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/16 11:34
 */
@Mapper
public interface User2Mapper extends CustomizeMapper<TUser> {

    /**
     * 通过Name查找用户
     * @param name
     * @return
     */
    @Select("SELECT * FROM T_USER WHERE NAME = #{name}")
    TUser findByName(@Param("name") String name);
}
