package com.shamengxin.bank.service.impl;

import com.shamengxin.bank.dao.AccountDao;
import com.shamengxin.bank.pojo.Account;
import com.shamengxin.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService2")
public class AccountServiceImpl2 implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Override
    // @Transactional(propagation = Propagation.REQUIRED)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(Account account) {

        accountDao.insert(account);

        /*String s = null;
        s.toString();*/

    }
}
