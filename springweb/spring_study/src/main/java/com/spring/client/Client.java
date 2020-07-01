package com.spring.client;

import com.spring.aop.AccountAspect;
import com.spring.aop.AccountServiceImpl;
import com.spring.aop.IAccountService;
import com.spring.aop.ProxyFactory;
import com.spring.proxy.AccountProxy;
import com.spring.service.AccountAdvice;
import com.spring.service.AccountService;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author liwenxing
 * @Version 21.0
 * @Description
 * @date 2020/6/24 11:33
 */
public class Client {

    public static void main(String[] args) {
        /*//创建目标对象
        IAccountService target = new AccountServiceImpl();
        //创建代理对象
        AccountProxy proxy = new AccountProxy(target);
        proxy.transfer();*/
        //创建目标对象
       /* AccountService target = new AccountService();
        //
        //创建代理对象
        AccountService proxy = (AccountService) Enhancer.create(target.getClass(),
                new AccountAdvice());
        proxy.transfer();*/
        // 目标对象
        IAccountService accountService = new AccountServiceImpl();
        // 切面
        AccountAspect accountAspect = new AccountAspect();
        IAccountService iAccountService = ProxyFactory.createProxy(accountService.getClass(),accountAspect);
        iAccountService.transfer();

    }
}
