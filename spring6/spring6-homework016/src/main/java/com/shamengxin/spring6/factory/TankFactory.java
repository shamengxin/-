package com.shamengxin.spring6.factory;

/**
 * 具体工厂
 */
public class TankFactory implements WeaponFactory{
    @Override
    public Weapon get() {
        return new Tank();
    }
}
