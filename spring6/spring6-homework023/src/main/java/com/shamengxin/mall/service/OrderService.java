package com.shamengxin.mall.service;

/**
 * 订单接口
 */
public interface OrderService {

    /**
     * 生成订单
     */
    void generate();

    /**
     * 查看订单
     */
    void detail();

    /**
     * 修改订单
     */
    void modify();
}
