package com.study.service;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/19 19:48
 */
public interface AccountService {
    /** 转账 */
    void transfer(String outer ,String inner ,Integer money);
}
