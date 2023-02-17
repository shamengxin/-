package com.shamengxin.bank.service;

import com.shamengxin.bank.pojo.Account;

import java.util.List;

public interface AccountService {

    /**
     * 添加账户
     * @param act
     * @return
     */
    int save(Account act);

    /**
     * 根据账号删除帐户
     * @param actno
     * @return
     */
    int deleteByActno(String actno);

    /**
     * 修改账户
     * @param act
     * @return
     */
    int update(Account act);

    /**
     * 根据账号查用户
     * @param actno
     * @return
     */
    Account getByActno(String actno);

    /**
     * 查询所有用户
     * @return
     */
    List<Account> getAll();

    /**
     * 转账
     * @param fromActno
     * @param toActno
     * @param money
     */
    void transfer(String fromActno,String toActno,double money);

}
