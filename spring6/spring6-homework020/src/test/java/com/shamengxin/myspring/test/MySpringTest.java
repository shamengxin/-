package com.shamengxin.myspring.test;

import org.junit.Test;
import org.myspringframework.core.ClassPathXmlApplicationContext;

public class MySpringTest {
    @Test
    public void testMySpring(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("myspring.xml");
        Object user = applicationContext.getBean("user");
        Object address = applicationContext.getBean("address");
        System.out.println(user);
        System.out.println(address);
    }
}
