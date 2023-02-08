package com.shamengxin.mybatis.test;

import com.shamengxin.mybatis.mapper.ClazzMapper;
import com.shamengxin.mybatis.pojo.Clazz;
import com.shamengxin.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class ClazzMapperTest {

    @Test
    public void testSelectByStep1(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectByStep1(1000);
        // System.out.println(clazz);

        //只访问班级名字。
        System.out.println(clazz.getCname());

        //只有用到的时候才回去执行第二步sql
        System.out.println(clazz.getStus());

        sqlSession.close();
    }

    @Test
    public void testSelectByCollection(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectByCollection(1000);
        System.out.println(clazz);
        sqlSession.close();
    }
}
