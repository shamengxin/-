package com.shamengxin.spring6.test;

import com.shamengxin.spring6.beans.MyDataSource;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UtilTest {

    @Test
    public void testUtil(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        MyDataSource myDataSource1 = applicationContext.getBean("MyDataSource1", MyDataSource.class);
        // MyDataSource myDataSource2 = applicationContext.getBean("MyDataSource2", MyDataSource.class);
        System.out.println(myDataSource1);
        // System.out.println(myDataSource2);
    }

}
