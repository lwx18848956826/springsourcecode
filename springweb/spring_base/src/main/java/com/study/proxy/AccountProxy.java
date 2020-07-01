package com.study.proxy;

import com.study.service.IAccountService;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/19 18:10
 */
public class AccountProxy implements IAccountService {

    /** 目标对象 */
    private IAccountService target;

    public AccountProxy(IAccountService target) {
        this.target = target;
    }


    /**
     * 代理方法,实现对目标方法的功能增强
     */
    @Override
    public void transfer() {
        before();
        target.transfer();
    }

    /**
     * 身份验证
     */
    private void before() {
        System.out.println("对转账人身份进行验证.");
    }
}
