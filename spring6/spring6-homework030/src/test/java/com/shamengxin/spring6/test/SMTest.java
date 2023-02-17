package com.shamengxin.spring6.test;

import com.shamengxin.bank.pojo.Account;
import com.shamengxin.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;

public class SMTest {

    @Test
    public void testTransfer(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        accountService.transfer("act-002","act-003",10000.0);
    }

    @Test
    public void testSM(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        Account account = new Account("act-003", 1000.0);
        accountService.save(account);
        accountService.deleteByActno("act-001");
        Account account1 = new Account("act-002",12344.0);
        accountService.update(account1);
        accountService.getByActno("act-002");
        accountService.getAll();
    }

}
