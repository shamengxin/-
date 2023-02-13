package com.shamengxin.myspring.test;

import org.junit.Test;
import org.myspringframework.core.ClassPathXmlApplicationContext;

public class MySpringTest {

    @Test
    public void testMySpring(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("myspring.xml");
        Object addrBean = applicationContext.getBean("addrBean");
        Object userBean = applicationContext.getBean("userBean");
        System.out.println(addrBean);
        System.out.println(userBean);
    }

}
