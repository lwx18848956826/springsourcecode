package com.example.starterweb.gener;

import tk.mybatis.mapper.genid.GenId;

import java.util.UUID;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/16 11:29
 */
public class UuidGenId implements GenId<String> {
    @Override
    public String genId(String s, String s1) {
        return UUID.randomUUID().toString().replace("-","");
    }
}
