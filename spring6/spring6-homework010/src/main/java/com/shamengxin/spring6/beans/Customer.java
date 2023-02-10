package com.shamengxin.spring6.beans;

public class Customer {
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Customer(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Customer() {
    }
}
