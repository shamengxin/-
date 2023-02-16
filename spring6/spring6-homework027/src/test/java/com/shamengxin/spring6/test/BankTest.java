package com.shamengxin.spring6.test;

import com.shamengxin.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;

public class BankTest {

    @Test
    public void testTransfer(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        try{
            accountService.transfer("act-001","act-002",10000);
            System.out.println("转帐成功~");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
