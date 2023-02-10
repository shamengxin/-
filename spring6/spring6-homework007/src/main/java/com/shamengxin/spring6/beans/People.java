package com.shamengxin.spring6.beans;

import java.util.List;

public class People {
    private List<String> names;

    @Override
    public String toString() {
        return "People{" +
                "names=" + names +
                '}';
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public People(List<String> names) {
        this.names = names;
    }

    public People() {
    }
}
