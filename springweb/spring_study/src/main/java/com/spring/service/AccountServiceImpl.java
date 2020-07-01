package com.spring.service;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/24 9:55
 */
public class AccountServiceImpl implements IAccountService {

    /*public static void main(String[] args) {
      boolean result = false;
      System.out.println(result);
    }*/
    
    @Override
    public void transfer() {
        System.out.println("调用dao层,完成转账主业务.");
    }
}
