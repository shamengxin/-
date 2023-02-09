package com.shamengxin.mybatis.test;

import com.shamengxin.mybatis.mapper.CarMapper;
import com.shamengxin.mybatis.pojo.Car;
import com.shamengxin.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class CarMapperTest {

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(171L);
        System.out.println(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(171L,"6666","丰田霸道1",32.0,"2020-11-11","燃油车");
        int count = mapper.update(car);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.deleteById(169L);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsert(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null,"6666","丰田霸道",32.0,"2020-11-11","燃油车");
        int count = mapper.insert(car);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }
}
