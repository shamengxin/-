package com.shamengxin.spring6.test;

import com.shamengxin.spring6.dao.User;
import com.shamengxin.spring6.dao.Vip;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Spring6Test {

    @Test
    public void testUser(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("UserBean", User.class);
        Vip vipBean = applicationContext.getBean("VipBean", Vip.class);
        System.out.println(vipBean);
        System.out.println(user);
        Date dataBean = applicationContext.getBean("DataBean", Date.class);
        System.out.println(dataBean);
    }

}
