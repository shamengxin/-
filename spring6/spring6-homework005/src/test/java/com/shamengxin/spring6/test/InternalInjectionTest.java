package com.shamengxin.spring6.test;

import com.shamengxin.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InternalInjectionTest {

    @Test
    public void testInternalInjection(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userServiceBean = applicationContext.getBean("UserServiceBean", UserService.class);
        userServiceBean.userSave();
    }
}
