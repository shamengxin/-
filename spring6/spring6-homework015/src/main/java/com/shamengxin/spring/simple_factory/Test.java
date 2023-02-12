package com.shamengxin.spring.simple_factory;

/**
 * 简单工厂模式测试
 */
public class Test {
    public static void main(String[] args) {
        Weapon tank = WeaponFactory.get("Tank");
        tank.attack();
        Weapon gun = WeaponFactory.get("Gun");
        gun.attack();
    }
}
