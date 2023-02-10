package com.shamengxin.spring6.service;

import com.shamengxin.spring6.dao.OrderDao;
import com.shamengxin.spring6.dao.UserDao;

public class OrderService {
    private UserDao userDao;
    private OrderDao orderDao;

    public OrderService() {
    }

    public OrderService(UserDao userDao, OrderDao orderDao) {
        this.userDao = userDao;
        this.orderDao = orderDao;
    }

    public void userSave(){
        userDao.save();
    }

    public void orderDelete(){
        orderDao.delete();
    }
}
