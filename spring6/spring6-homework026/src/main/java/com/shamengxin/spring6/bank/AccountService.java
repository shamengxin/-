package com.shamengxin.spring6.bank;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

    public void transfer(){
        System.out.println("正在进行转账操作");
    }

    public void withdraw(){
        System.out.println("正在进行取款操作");
    }

}
