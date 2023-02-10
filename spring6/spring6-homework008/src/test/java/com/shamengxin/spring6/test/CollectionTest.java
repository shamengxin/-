package com.shamengxin.spring6.test;

import com.shamengxin.spring6.beans.People;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class CollectionTest {

    //properties注入
    @Test
    public void testProperties(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        People people = applicationContext.getBean("People", People.class);
        System.out.println(people);
    }

    //map注入
    @Test
    public void testMap(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        People people = applicationContext.getBean("People", People.class);
        System.out.println(people);
    }
}
