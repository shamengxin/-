package com.shamengxin.bank.mapper;

import com.shamengxin.bank.pojo.Account;

import java.util.List;

public interface AccountMapper {

    /**
     * 添加账户
     * @param act
     * @return
     */
    int insert(Account act);

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
    Account selectByActno(String actno);

    /**
     * 查询所有用户
     * @return
     */
    List<Account> selectAll();
}
