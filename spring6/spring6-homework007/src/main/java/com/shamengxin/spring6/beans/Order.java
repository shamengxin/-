package com.shamengxin.spring6.beans;

import java.util.Arrays;

public class Order {
    private Goods[] goods;

    public Order() {

    }

    @Override
    public String toString() {
        return "Order{" +
                "goods=" + Arrays.toString(goods) +
                '}';
    }

    public Goods[] getGoods() {
        return goods;
    }

    public void setGoods(Goods[] goods) {
        this.goods = goods;
    }

    public Order(Goods[] goods) {
        this.goods = goods;
    }
}
