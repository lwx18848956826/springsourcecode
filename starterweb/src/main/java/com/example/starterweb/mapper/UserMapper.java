package com.example.starterweb.mapper;

import com.example.starterweb.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/15 10:58
 */
public interface UserMapper {

    /**
     * 通过Name查找用户
     * @param name
     * @return
     */
    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    /**
     * 插入用户
     * @param name
     * @param age
     * @return
     */
    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

}
