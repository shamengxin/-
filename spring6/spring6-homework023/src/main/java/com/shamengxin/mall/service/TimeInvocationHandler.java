package com.shamengxin.mall.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeInvocationHandler implements InvocationHandler {

    private Object target;

    public TimeInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object value = method.invoke(target, args);
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end-start)+"毫秒");
        return value;
    }
}
