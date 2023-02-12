package com.shamengxin.test;

import com.shamengxin.spring6.service.AccountService;
import com.shamengxin.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoTest {

    @Test
    public void testAutoByType(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        accountService.insert();
    }
    
    @Test
    public void testAutoByName(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.save();
    }

}
