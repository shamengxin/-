package com.shamengxin.spring6.factory;

/**
 * 具体产品
 */
public class Gun extends Weapon{
    @Override
    public void attack() {
        System.out.println("开枪");
    }
}
