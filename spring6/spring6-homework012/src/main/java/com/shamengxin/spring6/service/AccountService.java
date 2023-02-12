package com.shamengxin.spring6.service;

import com.shamengxin.spring6.dao.AccountDao;

public class AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void insert(){
        accountDao.insert();
    }
}
