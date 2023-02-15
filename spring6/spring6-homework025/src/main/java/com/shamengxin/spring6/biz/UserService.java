package com.shamengxin.spring6.biz;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void getUser(){
        System.out.println("获取用户信息");
    }

    public void saveUser(){
        System.out.println("保存用户信息");
    }

    public void deleteUser(){
        System.out.println("删除用户信息");
    }

    public void modifyUser(){
        System.out.println("更新用户信息");
    }

}
