package com.study.service.impl;

import com.study.dao.AccountDao;
import com.study.service.AccountService;
import com.study.service.IAccountService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/19 18:09
 */
@Component
public class AccountServiceImpl implements IAccountService, AccountService {

    private AccountDao accountDao;

//    private TransactionTemplate transactionTemplate;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

   /* public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }*/

    @Override
    public void transfer() {
        System.out.println("调用dao层,完成转账主业务.");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    public void transfer(final String outer, final String inner,final Integer money) {
        accountDao.out(outer, money);
        //模拟故障
        int i = 1/0;
        accountDao.in(inner, money);
      /*  transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                accountDao.out(outer, money);
                //模拟故障
//                int i = 1/0;
                accountDao.in(inner, money);
            }
        });*/
    }
}
