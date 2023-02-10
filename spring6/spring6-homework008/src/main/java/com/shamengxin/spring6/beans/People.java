package com.shamengxin.spring6.beans;

import java.util.Map;
import java.util.Properties;

public class People {
    private Map<Integer,String> addrs;

    private Properties properties;

    public People(Map<Integer, String> addrs, Properties properties) {
        this.addrs = addrs;
        this.properties = properties;
    }

    public Map<Integer, String> getAddrs() {
        return addrs;
    }

    public void setAddrs(Map<Integer, String> addrs) {
        this.addrs = addrs;
    }

    @Override
    public String toString() {
        return "People{" +
                "addrs=" + addrs +
                ", properties=" + properties +
                '}';
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public People() {
    }
}
