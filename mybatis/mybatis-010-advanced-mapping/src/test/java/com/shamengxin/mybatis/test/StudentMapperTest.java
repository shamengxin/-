package com.shamengxin.mybatis.test;

import com.shamengxin.mybatis.mapper.StudentMapper;
import com.shamengxin.mybatis.pojo.Student;
import com.shamengxin.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class StudentMapperTest {

    @Test
    public void testSelectByIdStep1(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectByIdStep1(5);
        // System.out.println(student);

        //只需要看学生的名字
        System.out.println(student.getSname());

        //程序执行到这了，我想看看班级的名字
        // System.out.println(student.getClazz().getCname());
        sqlSession.close();
    }

    @Test
    public void testSelectByIdAssociation(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectByIdAssociation(2);
        System.out.println(student);
        sqlSession.close();
    }

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectById(1);
        System.out.println(student);
        sqlSession.close();
    }
}
