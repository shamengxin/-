package com.shamengxin.mybatis.mapper;

import com.shamengxin.mybatis.pojo.Car;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface CarMapper {

    /**
     * 获取Car的总记录条数
     * @return
     */
    Long selectTotal();

    /**
     * 查询所有的Car信息。但是启用了驼峰命名自动映射机制。
     * @return
     */
    List<Car> selectAllByMapUnderscoreToCamelCase();

    /**
     * 查询所有的Car信息。使用resultMap标签进行结果映射。
     * @return
     */
    List<Car> selectAllByResultMap();

    /**
     * 查询所有的Car，返回一个大Map集合。
     * Map集合的key是每条记录的主键值。
     * Map集合的value是每条记录
     * {
     *      165={car_num=6666, id=165, guide_price=32.00, produce_time=2020-11-11, brand=丰田霸道, car_type=燃油车},
     *      166={car_num=1202, id=166, guide_price=30.00, produce_time=2020-11-11, brand=大众速腾, car_type=燃油车},
     *      167={car_num=1203, id=167, guide_price=5.00, produce_time=2010-12-03, brand=奔驰GLC, car_type=燃油车},
     *      168={car_num=1204, id=168, guide_price=3.00, produce_time=2009-10-11, brand=奥迪Q7, car_type=燃油车},
     *      169={car_num=1205, id=169, guide_price=4.00, produce_time=2001-10-11, brand=朗逸, car_type=新能源},
     *      171={car_num=1207, id=171, guide_price=30.00, produce_time=2000-01-02, brand=奥迪A6, car_type=燃油车},
     *      172={car_num=6666, id=172, guide_price=32.00, produce_time=2020-11-11, brand=丰田霸道, car_type=燃油车},
     *      173={car_num=9999, id=173, guide_price=30.00, produce_time=2023-10-11, brand=凯美瑞, car_type=燃油车}
     * }
     * @return
     */
    @MapKey("id")//将查询结果的id值作为整个大Map集合的key
    Map<Long,Map<String,Object>> selectAllRetMap();

    /**
     * 查询所有的Car信息。返回一个存放Map集合的List集合。
     * @return
     */
    List<Map<String ,Object>> selectAllRetListMap();

    /**
     * 根据id获取汽车信息，将汽车信息放到map集合中
     * +-----+---------+----------+-------------+--------------+-----------+
     * | id  | car_num | brand    | guide_price | produce_time | car_type  |
     * +-----+---------+----------+-------------+--------------+-----------+
     * | 168 | 1204    | 奥迪Q7    |        3.00 | 2009-10-11   | 燃油车     |
     * +-----+---------+----------+-------------+--------------+-----------+
     *
     * Map<String,Object>
     *     K               v
     *     -----------------
     *     "id"           168
     *     "car_num"      1204
     *     ....
     * @param id
     * @return
     */
    Map<String ,Object> selectByIdRetMap(Long id);

    /**
     * 根据id查询Car，id是主键，这个结果一定是一条。不可能有多条数据。那么这种情况可以使用list集合接受吗？
     * @param id
     * @return
     */
    List<Car> selectById2(Long id);

    /**
     * 根据品牌进行模糊查询。
     * 根据模糊查询的结果可能有多个，但是我采用一个POJO对象接收会有问题吗？
     * @param brand
     * @return
     */
    Car selectByBrandLike(String brand);

    /**
     * 获取所有的car
     * @return
     */
    List<Car> selectAll();

    /**
     * 根据id查询car信息
     * @param id
     * @return
     */
    Car selectById(Long id);
}
