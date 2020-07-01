package com.study.dao.impl;

import com.study.dao.AccountDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/19 19:46
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    @Override
    public void out(String outer, Integer money) {
        this.getJdbcTemplate().update("update account set money = money - ? where username = ?", money,outer);
    }

    @Override
    public void in(String inner, Integer money) {
        this.getJdbcTemplate().update("update account set money = money + ? where username = ?", money,inner);
    }
}
