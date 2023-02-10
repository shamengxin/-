package com.shamengxin.spring6.test;

import com.shamengxin.spring6.beans.Company;
import com.shamengxin.spring6.beans.Order;
import com.shamengxin.spring6.beans.People;
import com.shamengxin.spring6.beans.Person;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionTest {

    //Set集合注入
    @Test
    public void testSet(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Company company = applicationContext.getBean("Company", Company.class);
        System.out.println(company);
    }

    //List集合注入
    @Test
    public void testList(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        People people = applicationContext.getBean("People", People.class);
        System.out.println(people);
    }

    //数组当中元素为非简单类型
    @Test
    public void testArray2(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Order order = applicationContext.getBean("Order", Order.class);
        System.out.println(order);
    }

    //数组当中元素为简单类型
    @Test
    public void testArray(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Person person = applicationContext.getBean("Person", Person.class);
        System.out.println(person);
    }
}
