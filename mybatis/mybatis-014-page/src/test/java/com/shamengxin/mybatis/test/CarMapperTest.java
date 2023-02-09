package com.shamengxin.mybatis.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shamengxin.mybatis.mapper.CarMapper;
import com.shamengxin.mybatis.pojo.Car;
import com.shamengxin.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CarMapperTest {

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        //获取每页显示的记录条数
        int pageSize = 3;
        //显示第几页：页码
        int pageNum = 1;
        //一定一定在执行Sql语句之前，开启分页功能
        PageHelper.startPage(pageNum,pageSize);

        List<Car> cars = mapper.selectAll();
        // cars.forEach(car -> { System.out.println(car); });

        //封装分页信息对象new PageInfo()
        //PageInfo对象是PageHelper插件提供的，用来封装分页相关信息的对象。
        PageInfo<Car> carPageInfo = new PageInfo<>(cars,2);

        System.out.println(carPageInfo);

        sqlSession.close();

        /*
        PageInfo{pageNum=1, pageSize=3, size=3, startRow=1, endRow=3, total=4, pages=2,
         list=Page{count=true, pageNum=1, pageSize=3, startRow=0, endRow=3, total=4, pages=2, reasonable=false, pageSizeZero=false}
         [Car{id=169, carNum='1205', brand='朗逸', guidePrice=4.00, produceTime='2001-10-11', carType='新能源'},
         Car{id=171, carNum='1207', brand='奥迪A6', guidePrice=30.00, produceTime='2000-01-02', carType='燃油车'},
         Car{id=172, carNum='6666', brand='丰田霸道', guidePrice=32.00, produceTime='2020-11-11', carType='燃油车'}],
         prePage=0, nextPage=2, isFirstPage=true, isLastPage=false, hasPreviousPage=false, hasNextPage=true,
         navigatePages=2, navigateFirstPage=1, navigateLastPage=2, navigatepageNums=[1, 2]}
         */
    }

    @Test
    public void testSelectByPage(){
        //获取每页显示的记录条数
        int pageSize = 3;
        //显示第几页：页码
        int pageNum = 1;
        //计算开始下标
        int startIndex = (pageNum-1)*pageSize;

        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByPage(startIndex,pageSize);
        cars.forEach(car -> {
            System.out.println(car);
        });
        sqlSession.close();
    }

}
