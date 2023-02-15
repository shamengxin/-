package com.shamengxin.mall.service;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TimeMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        long start = System.currentTimeMillis();
        Object value = methodProxy.invokeSuper(o, objects);
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end-start)+"毫秒");
        return value;
    }
}
