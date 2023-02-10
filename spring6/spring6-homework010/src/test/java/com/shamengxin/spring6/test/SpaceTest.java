package com.shamengxin.spring6.test;

import com.shamengxin.spring6.beans.Customer;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpaceTest {

    @Test
    public void test_C(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-c.xml");
        Customer customer1 = applicationContext.getBean("Customer1", Customer.class);
        System.out.println(customer1);
        Customer customer2 = applicationContext.getBean("Customer2", Customer.class);
        System.out.println(customer2);
    }

    @Test
    public void test_P(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-p.xml");
        Customer customer1 = applicationContext.getBean("Customer1", Customer.class);
        System.out.println(customer1);
    }
}
