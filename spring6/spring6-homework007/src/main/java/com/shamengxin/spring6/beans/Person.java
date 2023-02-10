package com.shamengxin.spring6.beans;

import java.util.Arrays;

public class Person {
    private String [] favoriteFoods;

    @Override
    public String toString() {
        return "Person{" +
                "favoriteFoods=" + Arrays.toString(favoriteFoods) +
                '}';
    }

    public String[] getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(String[] favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

    public Person(String[] favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

    public Person() {
    }
}
