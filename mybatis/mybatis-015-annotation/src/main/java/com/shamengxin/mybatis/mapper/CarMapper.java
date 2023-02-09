package com.shamengxin.mybatis.mapper;

import com.shamengxin.mybatis.pojo.Car;
import org.apache.ibatis.annotations.*;

public interface CarMapper {

    @Select("select * from t_car where id = #{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "car_num",column = "carNum"),
            @Result(property = "brand",column = "brand"),
            @Result(property = "guide_price",column = "guidePrice"),
            @Result(property = "produce_time",column = "produceTime"),
            @Result(property = "car_type",column = "carType")
    })
    Car selectById(Long id);

    @Update("update t_car set car_num=#{carNum},brand=#{brand},guide_price=#{guidePrice},produce_time=#{produceTime},car_type=#{carType} where id=#{id}")
    int update(Car car);

    @Delete("delete from t_car where id = #{id}")
    int deleteById(Long id);

    @Insert("insert into t_car values(null,#{carNum},#{brand},#{guidePrice},#{produceTime},#{carType})")
    int insert(Car car);
}
