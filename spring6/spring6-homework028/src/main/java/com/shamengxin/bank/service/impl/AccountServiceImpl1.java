package com.shamengxin.bank.service.impl;

import com.shamengxin.bank.dao.AccountDao;
import com.shamengxin.bank.pojo.Account;
import com.shamengxin.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService1")
public class AccountServiceImpl1 implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Resource(name = "accountService2")
    private AccountService accountService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Account account) {

        accountDao.insert(account);// 保存act-003账户

        Account account2 = new Account("act-004", 1000.0);

        try {

            accountService.save(account2);//保存act--004

        }catch (Exception e){

        }

    }
}
