package com.example.starterweb.controller;

import com.example.starterweb.annotation.Authentication;
import com.example.starterweb.annotation.BehaviorDesc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/15 9:43
 */
@Api(value = "自定义注解相关api", tags = {"CustomAnnotation-api"}) //swagger注解
@RestController
@Slf4j
public class MainController {

    @ApiOperation(value = "Authentication/BehaviorDesc", notes = "权限验证/行为描述") //swagger注解
    @BehaviorDesc("未知操作") //该注解的优先级是 0，注解越小优先级越高
    @Authentication //该注解的优先级是 -1，所以这个注解优先级是高于上面的
    @GetMapping("/select")
    public String select(String role) {
        log.info("select method");
        return "select success";
    }
}
