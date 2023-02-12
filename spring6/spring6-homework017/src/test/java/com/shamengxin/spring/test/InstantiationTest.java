package com.shamengxin.spring.test;

import com.shamengxin.spring6.beans.Vip;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstantiationTest {

    @Test
    public void testByFactory(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Vip vip = applicationContext.getBean("Vip", Vip.class);
        System.out.println(vip);

    }

    @Test
    public void testBySimpleFactory(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

    }

    @Test
    public void testByStructure(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    }
}
