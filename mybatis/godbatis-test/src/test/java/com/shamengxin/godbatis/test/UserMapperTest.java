package com.shamengxin.godbatis.test;

import com.shamenxin.godbatis.pojo.User;
import org.god.ibatis.core.SqlSession;
import org.god.ibatis.core.SqlSessionFactory;
import org.god.ibatis.core.SqlSessionFactoryBuilder;
import org.god.ibatis.utils.Resources;
import org.junit.Test;

public class UserMapperTest {
    @Test
    public void testInsertUser(){
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("godbatis-config.xml"));
        SqlSession sqlSession = sessionFactory.openSession();
        User user = new User("1112", "lisi", "23");
        int count = sqlSession.insert("user.insertUser", user);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectById(){
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("godbatis-config.xml"));
        SqlSession sqlSession = sessionFactory.openSession();
        Object obj = sqlSession.selectOne("user.selectById", "1111");
        System.out.println(obj);
        sqlSession.close();
    }
}
