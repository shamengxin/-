package com.shamengxin.spring6.test;

import com.shamengxin.spring6.dao.OrderDao;
import com.shamengxin.spring6.service.OrderService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorTest {
    @Test
    public void testConstructor(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        OrderService orderServiceBean = applicationContext.getBean("OrderServiceBean", OrderService.class);
        orderServiceBean.orderDelete();
        orderServiceBean.userSave();

    }
}
