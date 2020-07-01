package com.study.client;

import com.study.proxy.AccountProxy;
import com.study.service.IAccountService;
import com.study.service.impl.AccountServiceImpl;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/19 18:13
 */
public class Client {

    public static void main(String[] args) {
        //创建目标对象
        IAccountService target = new AccountServiceImpl();
        //创建代理对象
        AccountProxy proxy = new AccountProxy(target);
        proxy.transfer();

    }
}
