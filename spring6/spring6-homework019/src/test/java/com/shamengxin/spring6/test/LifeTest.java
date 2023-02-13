package com.shamengxin.spring6.test;

import com.shamengxin.spring6.bean.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeTest {
    @Test
    public void testLife(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("User", User.class);
        System.out.println("4.使用bean");
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext)applicationContext;
        context.close();
    }

}
