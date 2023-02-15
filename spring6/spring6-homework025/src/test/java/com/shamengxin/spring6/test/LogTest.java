package com.shamengxin.spring6.test;

import com.shamengxin.spring6.biz.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LogTest {

    @Test
    public void testLog(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.getUser();
        userService.deleteUser();
        userService.saveUser();
        userService.modifyUser();
    }
}
