package com.shamengxin.spring6.test;

import com.shamengxin.spring6.beans.Vip;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NullTest {

    @Test
    public void testSpecial(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Vip vip5 = applicationContext.getBean("Vip5", Vip.class);
        System.out.println(vip5);
        Vip vip6 = applicationContext.getBean("Vip6", Vip.class);
        System.out.println(vip6);
    }

    @Test
    public void testEmpty(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Vip vip2 = applicationContext.getBean("Vip2", Vip.class);
        System.out.println(vip2);
        Vip vip3 = applicationContext.getBean("Vip3", Vip.class);
        System.out.println(vip3);
    }

    @Test
    public void testNull(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Vip vip1 = applicationContext.getBean("Vip1", Vip.class);
        System.out.println(vip1);
        Vip vip4 = applicationContext.getBean("Vip4", Vip.class);
        System.out.println(vip4);
    }

}
