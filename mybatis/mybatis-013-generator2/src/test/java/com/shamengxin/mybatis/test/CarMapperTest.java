package com.shamengxin.mybatis.test;

import com.shamengxin.mybatis.mapper.CarMapper;
import com.shamengxin.mybatis.pojo.Car;
import com.shamengxin.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class CarMapperTest {
    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectByPrimaryKey(169L);
        System.out.println(car);
        sqlSession.close();
    }

    @Test
    public void testDeleteByPrimaryKey(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.deleteByPrimaryKey(168L);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }
}
