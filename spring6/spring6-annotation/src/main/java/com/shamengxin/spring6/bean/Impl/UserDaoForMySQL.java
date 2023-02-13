package com.shamengxin.spring6.bean.Impl;

import com.shamengxin.spring6.bean.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoForMySQL implements UserDao {

    @Override
    public void insert() {
        System.out.println("向mysql中插入数据");
    }
}
