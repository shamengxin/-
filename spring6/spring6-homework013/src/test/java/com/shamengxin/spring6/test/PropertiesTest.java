package com.shamengxin.spring6.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertiesTest {
    @Test
    public void testProperties(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Object myDataSource = applicationContext.getBean("MyDataSource");
        System.out.println(myDataSource);
    }
}
