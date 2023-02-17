package com.shamengxin.spring6.test;

import com.shamengxin.bank.pojo.Account;
import com.shamengxin.bank.service.IsolationService1;
import com.shamengxin.bank.service.IsolationService2;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IsolationTest {

    @Test
    public void testIsolation1(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        IsolationService1 i1 = applicationContext.getBean("i1", IsolationService1.class);
        i1.getByActno("act-004");
    }

    @Test
    public void testIsolation2() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        IsolationService2 i2 = applicationContext.getBean("i2", IsolationService2.class);
        Account act = new Account("act-004", 1000.0);
        i2.save(act);
    }
}
