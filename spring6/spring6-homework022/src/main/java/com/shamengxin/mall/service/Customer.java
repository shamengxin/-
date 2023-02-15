package com.shamengxin.mall.service;

import com.shamengxin.mall.service.impl.OrderServiceImpl;

public class Customer {

    public static void main(String[] args) {
        OrderService target = new OrderServiceImpl();

        OrderService proxy = new OrderServiceProxy(target);

        proxy.generate();
        proxy.modify();
        proxy.detail();
    }
}
