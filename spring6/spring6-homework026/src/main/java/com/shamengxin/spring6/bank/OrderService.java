package com.shamengxin.spring6.bank;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public void generate(){
        System.out.println("正在生成订单");
    }

    public  void cancel(){
        System.out.println("正在取消订单");
    }

}
