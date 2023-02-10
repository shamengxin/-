package com.shamengxin.spring6.beans;

import java.util.Properties;

public class MyDataSource {
    private Properties properties;

    @Override
    public String toString() {
        return "MyDataSource{" +
                "properties=" + properties +
                '}';
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public MyDataSource() {
    }

    public MyDataSource(Properties properties) {
        this.properties = properties;
    }
}
