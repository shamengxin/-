package com.shamengxin.spring6.test;

import com.shamengxin.spring6.bank.AccountService;
import com.shamengxin.spring6.bank.OrderService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTest {

    @Test
    public void testTransaction(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        accountService.transfer();
        accountService.withdraw();
        orderService.generate();
        orderService.cancel();
    }

}
