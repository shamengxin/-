package com.shamengxin.spring6.test;

import com.shamengxin.spring6.beans.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CascadeAssignmentTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = applicationContext.getBean("Student", Student.class);
        System.out.println(student);
    }
}
