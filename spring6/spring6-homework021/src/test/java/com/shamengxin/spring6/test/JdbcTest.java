package com.shamengxin.spring6.test;

import com.shamengxin.spring6.bean.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JdbcTest {

    @Test
    public void testCallback() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select * from t_user where id=?";
        User user = jdbcTemplate.execute(sql, new PreparedStatementCallback<User>() {
            @Override
            public User doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                User user = null;
                ps.setInt(1, 3);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setRealName(rs.getString("real_name"));
                    user.setAge(rs.getInt("age"));
                }
                return user;
            }
        });
        System.out.println(user);
    }

    @Test
    public void testDeleteBatch(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "delete from t_user where id = ?";

        Object[] objs1 = {5};
        Object[] objs2 = {6};
        Object[] objs3 = {7};
        List<Object[]> list = new ArrayList<>();
        list.add(objs1);
        list.add(objs2);
        list.add(objs3);

        int[] count = jdbcTemplate.batchUpdate(sql,list);
        System.out.println(Arrays.toString(count));
    }

    @Test
    public void testUpdateBatch(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "update t_user set real_name = ?,age = ? where id = ?";

        Object[] objs1 = {"小花111",20,8};
        Object[] objs2 = {"小明222",20,9};
        Object[] objs3 = {"小红333",20,10};
        List<Object[]> list = new ArrayList<>();
        list.add(objs1);
        list.add(objs2);
        list.add(objs3);

        int[] count = jdbcTemplate.batchUpdate(sql,list);
        System.out.println(Arrays.toString(count));
    }

    @Test
    public void testAddBatch(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "insert into t_user(real_name,age)values(?,?)";

        Object[] objs1 = {"小花",20};
        Object[] objs2 = {"小明",20};
        Object[] objs3 = {"小红",20};
        List<Object[]> list = new ArrayList<>();
        list.add(objs1);
        list.add(objs2);
        list.add(objs3);

        int[] count = jdbcTemplate.batchUpdate(sql,list);
        System.out.println(Arrays.toString(count));
    }

    @Test
    public void testSelectOneValue(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select count(*) from t_user";
        Integer count = jdbcTemplate.queryForObject(sql, int.class);
        System.out.println(count);
    }

    @Test
    public void testSelectAll(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select * from t_user";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println(userList);
    }

    @Test
    public void testSelectOne(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select * from t_user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 2);
        System.out.println(user);
    }

    @Test
    public void testDelete(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "delete from t_user where id = ?";
        int count = jdbcTemplate.update(sql,1);
        System.out.println("删除的记录条数："+count);
    }

    @Test
    public void testUpdate(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "update t_user set real_name = ?,age = ? where id = ?";
        int count = jdbcTemplate.update(sql, "张三丰", 15,1);
        System.out.println("更新的记录条数："+count);
    }

    @Test
    public void testInsert(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "insert into t_user(real_name,age)values(?,?)";
        int count = jdbcTemplate.update(sql, "赵六", 20);
        System.out.println("插入的记录条数："+count);

    }

}
