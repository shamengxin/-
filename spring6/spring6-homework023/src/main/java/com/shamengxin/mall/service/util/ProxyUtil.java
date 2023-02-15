package com.shamengxin.mall.service.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {

    public static Object getProxy(Object target){

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                long start = System.currentTimeMillis();
                Object value = method.invoke(target, args);
                long end = System.currentTimeMillis();
                System.out.println("耗时"+(end-start)+"毫秒");

                return value;
            }
        });

    }

}
