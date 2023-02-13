package com.shamengxin.spring6.bean.Impl;

import com.shamengxin.spring6.bean.UserDao;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoForOracle implements UserDao {

    @Override
    public void insert() {
        System.out.println("向oracle中插入数据");
    }
}
