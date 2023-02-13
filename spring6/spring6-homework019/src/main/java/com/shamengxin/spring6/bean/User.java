package com.shamengxin.spring6.bean;

public class User {
    private String name;

    public User() {
        System.out.println("1.实例化");
    }

    public void setName(String name) {
        System.out.println("2.属性赋值");
        this.name = name;
    }

    public void initBean(){
        System.out.println("3.初始化bean");
    }

    public void destroyBean(){
        System.out.println("5.销毁bean");
    }


}
