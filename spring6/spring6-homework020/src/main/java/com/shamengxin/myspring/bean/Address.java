package com.shamengxin.myspring.bean;

public class Address {
    private String local;

    @Override
    public String toString() {
        return "Address{" +
                "local='" + local + '\'' +
                '}';
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Address(String local) {
        this.local = local;
    }

    public Address() {
    }
}
