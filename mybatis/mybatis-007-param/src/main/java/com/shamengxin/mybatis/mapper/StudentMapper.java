package com.shamengxin.mybatis.mapper;

import com.shamengxin.mybatis.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StudentMapper {

    /**
     * Param注解。
     *
     * mybatis框架底层的实现原理：
     *  map.put("name",name);
     *  map.put("sex",sex);
     * @param name
     * @param sex
     * @return
     */
    List<Student> selectByNameAndSex2(@Param("name") String name,@Param("sex") Character sex);

    /**
     * 这是多参数
     * 根据name和sex查询student信息。
     * 如果是多个参数的话，mybatis框架底层是怎么做的呢？
     *      mybatis框架会自动创建一个Map集合。并且Map集合是以这种方式存储参数的：
     *          map.put("arg0",name);
     *          map.put("arg1",sex);
     *          map.put("param1",name);
     *          map.put("param2",sex);
     *
     * @param name
     * @param sex
     * @return
     */
    List<Student> selectByNameAndSex(String name,Character sex);

    /**
     * 保存学生信息，通过POJO参数。Student是单个参数。但是不是简单类型
     * @param student
     * @return
     */
    int insertStudentByPOJO(Student student);

    /**
     * 保存学生信息，通过Map参数。以下是单个参数。但参数类型不是简单类型。是Map集合。
     * @param map
     * @return
     */
    int insertStudentByMap(Map<String,Object> map);

    /**
     * 当接口中的方法参数只有一个（单个参数），并且参数的数据类型都是简单类型。
     * 根据id查询，name查询，brith查询，sex查询
     */
    List<Student> selectById(Long id);
    List<Student> selectByName(String id);
    List<Student> selectByBirth(Date id);
    List<Student> selectBySex(Character id);

}
