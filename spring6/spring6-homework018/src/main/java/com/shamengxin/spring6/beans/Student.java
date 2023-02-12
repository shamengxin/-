package com.shamengxin.spring6.beans;

import java.util.Date;

public class Student {
    private Date birth;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "birth=" + birth +
                '}';
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Student(Date birth) {
        this.birth = birth;
    }
}
