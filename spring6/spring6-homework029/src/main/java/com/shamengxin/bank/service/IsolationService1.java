package com.shamengxin.bank.service;

import com.shamengxin.bank.dao.AccountDao;
import com.shamengxin.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service("i1")
public class IsolationService1 {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    //负责查询
    //可以读取到对方为提交的数据
    // @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    //对方提交之后才能提取到
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void getByActno(String actno){
        Account account = accountDao.selectByActno(actno);
        System.out.println("查询到的账户信息："+account);
    }
}
