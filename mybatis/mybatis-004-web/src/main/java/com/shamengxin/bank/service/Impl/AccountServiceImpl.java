package com.shamengxin.bank.service.Impl;

import com.shamengxin.bank.dao.AccountDao;
import com.shamengxin.bank.dao.Impl.AccountDaoImpl;
import com.shamengxin.bank.exceptions.MoneyNotEnoughException;
import com.shamengxin.bank.exceptions.TransferException;
import com.shamengxin.bank.pojo.Account;
import com.shamengxin.bank.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = new AccountDaoImpl();

    @Override
    public void transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, TransferException {
        //1.判断转出账户的余额是否充足(select)
        Account fromAct = accountDao.selectByActno(fromActno);
        if (fromAct.getBalance()<money) {
            //2.如果转出账户余额不足，提示用户
            throw new MoneyNotEnoughException("对不起，余额不足");
        }
        //3.如果转出账户余额充足，更新转出账户余额(update)
        //先更新内存中java对象account的余额
        Account toAct = accountDao.selectByActno(toActno);
        fromAct.setBalance(fromAct.getBalance()-money);
        toAct.setBalance(toAct.getBalance()+money);
        int count = accountDao.updateByActno(fromAct);
        //4.更新转入账户余额(update)
        count += accountDao.updateByActno(toAct);
        if (count!=2) {
            throw new TransferException("转账异常，未知原因");
        }

    }
}
