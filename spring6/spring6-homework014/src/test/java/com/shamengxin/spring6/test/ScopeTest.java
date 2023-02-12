package com.shamengxin.spring6.test;

import com.shamengxin.spring6.beans.SpringBean;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    @Test
    public void testMyThread(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        SpringBean springBean1 = applicationContext.getBean("springBean4", SpringBean.class);
        System.out.println(springBean1);
        SpringBean springBean2 = applicationContext.getBean("springBean4", SpringBean.class);
        System.out.println(springBean2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                SpringBean springBean3 = applicationContext.getBean("springBean4", SpringBean.class);
                System.out.println(springBean3);
                SpringBean springBean4 = applicationContext.getBean("springBean4", SpringBean.class);
                System.out.println(springBean4);
            }
        }).start();
    }

    @Test
    public void testPrototype(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        SpringBean springBean1 = applicationContext.getBean("springBean3", SpringBean.class);
        System.out.println(springBean1);
        SpringBean springBean2 = applicationContext.getBean("springBean3", SpringBean.class);
        System.out.println(springBean2);
    }

    @Test
    public void testSingleton(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        SpringBean springBean1 = applicationContext.getBean("springBean2", SpringBean.class);
        System.out.println(springBean1);
        SpringBean springBean2 = applicationContext.getBean("springBean2", SpringBean.class);
        System.out.println(springBean2);
    }

    @Test
    public void testScope(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        SpringBean springBean1 = applicationContext.getBean("springBean1", SpringBean.class);
        System.out.println(springBean1);
        SpringBean springBean2 = applicationContext.getBean("springBean1", SpringBean.class);
        System.out.println(springBean2);
    }
}
