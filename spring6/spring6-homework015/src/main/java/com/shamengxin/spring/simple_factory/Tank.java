package com.shamengxin.spring.simple_factory;

/**
 * 具体实现类
 */
public class Tank extends Weapon{

    @Override
    public void attack() {
        System.out.println("坦克开炮！！");
    }
}
