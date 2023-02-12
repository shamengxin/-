package com.shamengxin.spring.simple_factory;

/**
 * 实现类
 */
public class Gun extends Weapon{
    @Override
    public void attack() {
        System.out.println("开枪！！！");
    }
}
