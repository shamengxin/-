package com.shamengxin.spring6.factory;

/**
 * 工厂模式测试
 */
public class Test {

    public static void main(String[] args) {
        WeaponFactory tankFactory = new TankFactory();
        Weapon tank = tankFactory.get();
        WeaponFactory gunFactory = new GunFactory();
        Weapon gun = gunFactory.get();
        tank.attack();
        gun.attack();

    }

}
