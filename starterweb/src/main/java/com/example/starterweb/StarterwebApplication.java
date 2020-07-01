package com.example.starterweb;

import com.john.springbootstarterredis.annotation.EnableEcho;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.starterweb.mapper","com.example.starterweb.dao"})
//@EnableEcho(packages = {"com.example.starterweb.controller"})
public class StarterwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarterwebApplication.class, args);
    }

}
