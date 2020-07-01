package com.study.client;

import com.study.dispatch.Dispatcher;
import com.study.service.AccountService;
import com.study.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/19 18:16
 */
public class Test {

    public static void main(String[] args) {
       /* //创建代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();
        //配置目标对象
        proxyFactory.setTarget(new AccountServiceImpl());
        // 配置增强
        proxyFactory.addAdvice(new AccountAdvice());
        IAccountService accountService = (IAccountService) proxyFactory.getProxy();
        accountService.transfer();*/

        /*ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        IAccountService proxy = (IAccountService) context.getBean("accountProxy");
        proxy.transfer();*/

      /*  ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        IAccountService proxy = (IAccountService) context.getBean("accountServiceImpl");
        proxy.transfer();*/
       /* String xmlPath = "ApplicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        AccountService accountService =  (AccountService) applicationContext.getBean("accountService");
        accountService.transfer("jack", "rose", 1000);*/
        Dispatcher dispather = new Dispatcher();
        dispather.doDispatch();

    }
}
