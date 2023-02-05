package com.shamengxin.mybatis.test;

import com.shamengxin.mybatis.mapper.LogMapper;
import com.shamengxin.mybatis.pojo.Log;
import com.shamengxin.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class LogMapperTest {
    @Test
    public void testSelectAllByTable(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        LogMapper mapper = sqlSession.getMapper(LogMapper.class);
        List<Log> logs = mapper.selectAllByTable("20220901");
        logs.forEach(log -> {
            System.out.println(log);
        });
        sqlSession.close();
    }
}
