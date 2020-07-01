package com.example.starterweb.gener;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/16 11:33
 */
public interface CustomizeMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
