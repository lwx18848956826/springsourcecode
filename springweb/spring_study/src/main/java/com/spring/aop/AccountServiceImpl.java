package com.spring.aop;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/24 11:57
 */
public class  AccountServiceImpl implements IAccountService {
    @Override
    public void transfer() {
        System.out.println("调用dao层,完成转账主业务.");
    }
}
