package com.shamengxin.spring6.test;

import com.shamengxin.spring6.beans.A;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class SimpleTypeTest {

    @Test
    public void testSimpleType(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        A aBean = applicationContext.getBean("ABean", A.class);
        System.out.println(aBean);
    }
}
