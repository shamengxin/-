package com.shamengxin.spring6.beans;

public class Goods {
    private String name;

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Goods(String name) {
        this.name = name;
    }

    public Goods() {
    }
}
