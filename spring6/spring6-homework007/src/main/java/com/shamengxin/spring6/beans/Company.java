package com.shamengxin.spring6.beans;

import java.util.Set;

public class Company {
    private Set<String> phones;

    @Override
    public String toString() {
        return "Company{" +
                "phones=" + phones +
                '}';
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    public Company(Set<String> phones) {
        this.phones = phones;
    }

    public Company() {
    }
}
