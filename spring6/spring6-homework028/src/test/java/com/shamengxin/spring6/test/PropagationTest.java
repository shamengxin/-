package com.shamengxin.spring6.test;

import com.shamengxin.bank.pojo.Account;
import com.shamengxin.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropagationTest {

    @Test
    public void testPropagation(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService1 = applicationContext.getBean("accountService1", AccountService.class);
        Account account = new Account("act-003", 10000.0);
        accountService1.save(account);
    }

}
