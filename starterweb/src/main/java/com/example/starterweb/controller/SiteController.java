package com.example.starterweb.controller;

import com.example.starterweb.annotation.TraceLog;
import com.example.starterweb.dto.LoginParam;
import com.john.springbootstartersite.site.SiteInformationProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author John Lee
 * @Version 1.0
 * @Description 自定义Starter测试Controller
 * @date 2020/6/12 14:16
 */
@RestController
public class SiteController {

    @Resource
    private SiteInformationProvider provider;

    @GetMapping(value = "/site/info")
    @TraceLog(business = "CRM", module = "LOGIN")
    public String getSiteInfo(LoginParam param) {
        return provider.getSiteInformation().toString() + param.toString();
    }
}
