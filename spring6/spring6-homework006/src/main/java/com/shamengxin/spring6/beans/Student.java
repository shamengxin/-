package com.shamengxin.spring6.beans;

public class Student {
    private String name;
    private Clazz clazz;

    public String getName() {
        return name;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public Student(String name, Clazz clazz) {
        this.name = name;
        this.clazz = clazz;
    }

    public Student() {
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", clazz=" + clazz +
                '}';
    }
}
