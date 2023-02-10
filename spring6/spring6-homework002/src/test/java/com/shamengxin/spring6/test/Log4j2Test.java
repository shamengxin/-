package com.shamengxin.spring6.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Log4j2Test {

    @Test
    public void testLog4j2(){
        new ClassPathXmlApplicationContext("spring.xml");

        Logger logger = LoggerFactory.getLogger(Log4j2Test.class);
        logger.info("我是一条消息");
        logger.debug("我是一条debug消息");
    }

}
