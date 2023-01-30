package com.shamengxin.mybatis.test;

import com.shamengxin.mybatis.pojo.Car;
import com.shamengxin.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CarMapperTest {

    @Test
    public void testNamespace(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // List<Object> cars = sqlSession.selectList("selectAll");
        //正确完整的写法：namespace.id
        List<Object> cars = sqlSession.selectList("aaaa.selectAll");
        cars.forEach(car-> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //执行sql语句。
        List<Object> cars = sqlSession.selectList("selectAll");
        //遍历
        cars.forEach(car-> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //执行sql语句。查询。根据id查询。返回结果一定是一条。
        //mybatis底层执行了select语句之后，一定会返回一个结果集对象：ResultSet
        //JDBC中叫做ResultSet，接下来就是mybatis因该从ResultSet中取出数据，封装java对象。
        Object car = sqlSession.selectOne("selectById", 1);
        System.out.println(car);
        sqlSession.close();
    }

    @Test
    public void testUpdateById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //准备数据
        Car car = new Car(7L,"9999","凯美瑞",30.0,"1999-10-11","燃油车");
        //执行sql语句
        int count = sqlSession.update("updateById", car);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void testDeleteById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //执行sql语句
        int count = sqlSession.delete("deleteById", 15);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();


    }

    @Test
    public void testInsertCarByPOJO(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //封装数据
        Car car = new Car(null,"3333","比亚迪秦3",30.0,"2020-11-11","新能源");
        //执行sql
        sqlSession.insert("insertCar",car);
        sqlSession.commit();
        sqlSession.close();


    }

    @Test
    public void testInsertCar(){
        SqlSession sqlSession = SqlSessionUtil.openSession();

        //前端传过来数据了。
        //这个对象我们先使用map集合进行数据的封装。
        /*Map<String, Object> map = new HashMap<>();
        map.put("k1","1111");
        map.put("k2","比亚迪汉");
        map.put("k3",10.0);
        map.put("k4","2020-11-11");
        map.put("k5","电车");*/

        Map<String, Object> map = new HashMap<>();
        map.put("carNum","1111");
        map.put("brand","比亚迪汉2");
        map.put("guidePrice",10.0);
        map.put("produceTime","2020-11-11");
        map.put("carType","电车");

        //执行sql语句
        //insert方法的参数：
        //第一个参数：sqlId，从CarMapper.xml文件中复制
        //第二个参数：封装数据的对象
        int count = sqlSession.insert("insertCar",map);
        System.out.println(count);

        sqlSession.commit();
        sqlSession.close();

    }
}
