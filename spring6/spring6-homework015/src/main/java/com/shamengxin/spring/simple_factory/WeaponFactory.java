package com.shamengxin.spring.simple_factory;

/**
 * 简单（静态）工厂模式
 */
public class WeaponFactory {

    public static Weapon get(String weaponName){
        if(weaponName==null || weaponName==""){
            return null;
        }
        Weapon weapon = null;
        if(weaponName.equals("Tank")){
            weapon = new Tank();
        }else if(weaponName.equals("Gun")){
            weapon=new Gun();
        }else {
            throw new RuntimeException("不支持该武器的生产");
        }
        return weapon;
    }

}
