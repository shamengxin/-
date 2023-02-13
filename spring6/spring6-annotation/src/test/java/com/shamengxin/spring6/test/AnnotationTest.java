package com.shamengxin.spring6.test;

import com.shamengxin.spring6.bean.BankDao;
import com.shamengxin.spring6.bean.Spring6Configuration;
import com.shamengxin.spring6.bean.User;
import com.shamengxin.spring6.bean.UserService;
import com.shamengxin.spring6.bean2.Order;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {

    @Test
    public void testConfiguration(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring6Configuration.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.save();
    }

    @Test
    public void testAutowired(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.save();
    }

    @Test
    public void testAnnotation(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
        /*BankDao bankDao = applicationContext.getBean("bankDao", BankDao.class);
        System.out.println(bankDao);
        Order order = applicationContext.getBean("order", Order.class);
        System.out.println(order);*/


    }

}
