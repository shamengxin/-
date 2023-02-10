package com.shamengxin.spring6.beans;

public class Clazz {
    private String name;

    @Override
    public String toString() {
        return "Clazz{" +
                "name='" + name + '\'' +
                '}';
    }

    public Clazz(String name) {
        this.name = name;
    }

    public Clazz() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
