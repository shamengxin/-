package com.shamengxin.spring6.factory;

/**
 * 具体产品
 */
public class Tank extends Weapon{
    @Override
    public void attack() {
        System.out.println("开炮！！！");
    }
}
