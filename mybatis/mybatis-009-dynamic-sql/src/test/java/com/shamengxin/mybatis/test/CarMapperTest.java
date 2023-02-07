package com.shamengxin.mybatis.test;

import com.shamengxin.mybatis.mapper.CarMapper;
import com.shamengxin.mybatis.pojo.Car;
import com.shamengxin.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CarMapperTest {

    @Test
    public void testDeleteByIds2() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long[] ids ={174L,175L,176L};
        int count = mapper.deleteByIds2(ids);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsetBatch() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car1 = new Car(null,"1200","帕萨特1",30.0,"2020-11-11","燃油车");
        Car car2 = new Car(null,"1201","帕萨特2",31.0,"2020-11-11","燃油车");
        Car car3 = new Car(null,"1202","帕萨特3",32.0,"2020-11-11","燃油车");
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        mapper.insetBatch(cars);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteByIds() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long[] ids ={165L,166L,167L};
        int count = mapper.deleteByIds(ids);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByChoose() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        //三个条件都不为空
        // List<Car> cars = mapper.selectByChoose("丰田霸道",1.0,"新能源");
        //第一个条件是空
        // List<Car> cars = mapper.selectByChoose(null,1.0,"新能源");
        //前两个条件都是空
        List<Car> cars = mapper.selectByChoose(null,null,"新能源");
        cars.forEach(car -> {
            System.out.println(car);
        });
        sqlSession.close();
    }

    @Test
    public void testUpdateBySet() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(165L,null,"丰田霸道",null,null,"燃油车");
        mapper.updateBySet(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(165L,null,"丰田霸道",null,null,"燃油车");
        mapper.updateById(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByMultiConditionWithTrim() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByMultiConditionWithWhere("",null,"");
        cars.forEach(car -> {
            System.out.println(car);
        });
        sqlSession.close();
    }

    @Test
    public void testSelectByMultiConditionWithWhere() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        //假设三个条件都不是空
        // List<Car> cars = mapper.selectByMultiConditionWithWhere("奥迪",2.0,"燃油车");

        ////假设三个条件都是空
        // List<Car> cars = mapper.selectByMultiConditionWithWhere("",null,"");

        //假设后两个条件不为空，第一个条件为空
        List<Car> cars = mapper.selectByMultiConditionWithWhere("",2.0,"燃油车");

        cars.forEach(car -> {
            System.out.println(car);
        });
        sqlSession.close();
    }
    @Test
    public void testSelectByMultiCondition(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        //假设三个条件都不是空
        // List<Car> cars = mapper.selectByMultiCondition("奥迪",2.0,"燃油车");

        //假设三个条件都是空
        // List<Car> cars = mapper.selectByMultiCondition("",null,"");

        //假设后两个条件不为空，第一个条件为空
        // List<Car> cars = mapper.selectByMultiCondition("",2.0,"燃油车");

        //假设第一个条件不是空，后两个条件是空
        List<Car> cars = mapper.selectByMultiCondition("奥迪",null,"");

        cars.forEach(car -> {
            System.out.println(car);
        });
        sqlSession.close();
    }

}
