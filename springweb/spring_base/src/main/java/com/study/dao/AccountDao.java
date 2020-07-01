package com.study.dao;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/19 19:45
 */
public interface AccountDao {

    /** 汇款 */
    void out(String outer , Integer money);

    /** 收款 */
    void in(String inner , Integer money);
}
