package com.shamengxin.mall.service;

import net.sf.cglib.proxy.Enhancer;

public class Client {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new TimeMethodInterceptor());
        UserService userServiceProxy = (UserService) enhancer.create();
        userServiceProxy.login();
        userServiceProxy.exit();
    }
}
