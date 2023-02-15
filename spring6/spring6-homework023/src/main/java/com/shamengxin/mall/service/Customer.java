package com.shamengxin.mall.service;

import com.shamengxin.mall.service.impl.OrderServiceImpl;
import com.shamengxin.mall.service.util.ProxyUtil;

import java.lang.reflect.Proxy;

public class Customer {
    public static void main(String[] args) {
        // OrderService target = new OrderServiceImpl();
        // OrderService orderServiceProcy = (OrderService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new TimeInvocationHandler(target));


        /**
         * 测试工具类
         */
        OrderService orderServiceProcy = (OrderService) ProxyUtil.getProxy(new OrderServiceImpl());

        orderServiceProcy.generate();
        orderServiceProcy.modify();
        orderServiceProcy.detail();
    }
}
