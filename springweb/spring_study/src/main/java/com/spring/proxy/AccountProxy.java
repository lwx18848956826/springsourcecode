package com.spring.proxy;

import com.spring.service.IAccountService;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/24 11:30
 */
public class AccountProxy implements IAccountService {

    /** 目标对象 */
    private IAccountService target;

    public AccountProxy(IAccountService target) {
        this.target = target;
    }

    @Override
    public void transfer() {
        before();
        target.transfer();
    }

    /**
     * 前置增强
     */
    private void before() {
        System.out.println("对转账人身份进行验证.");
    }
}
