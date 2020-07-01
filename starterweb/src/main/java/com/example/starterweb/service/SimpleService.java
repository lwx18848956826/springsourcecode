package com.example.starterweb.service;

import com.john.springbootstarterredis.annotation.Log;
import org.springframework.stereotype.Service;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/12 17:02
 */
@Service
public class SimpleService {

    @Log
    public void test(int num) {
        System.out.println("----test---- " + num);
    }

    @Log
    public void core(int num) {
        System.out.println("----core---- " + num);
    }

    public void work(int num) {
        System.out.println("----work---- " + num);
    }
}
