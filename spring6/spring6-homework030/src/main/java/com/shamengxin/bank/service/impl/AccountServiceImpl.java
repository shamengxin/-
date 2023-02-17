package com.shamengxin.bank.service.impl;

import com.shamengxin.bank.mapper.AccountMapper;
import com.shamengxin.bank.pojo.Account;
import com.shamengxin.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public int save(Account act) {
        int count = accountMapper.insert(act);
        return count;
    }

    @Override
    public int deleteByActno(String actno) {
        int count = accountMapper.deleteByActno(actno);
        return count;
    }

    @Override
    public int update(Account act) {
        int count = accountMapper.update(act);
        return count;
    }

    @Override
    public Account getByActno(String actno) {
        Account account = accountMapper.selectByActno(actno);
        return account;
    }

    @Override
    public List<Account> getAll() {
        List<Account> accounts = accountMapper.selectAll();
        return accounts;
    }

    @Override
    public void transfer(String fromActno, String toActno, double money) {
        Account fromAct = accountMapper.selectByActno(fromActno);
        if(fromAct.getBalance()<money){
            throw new RuntimeException("余额不足");
        }
        Account toact = accountMapper.selectByActno(toActno);
        fromAct.setBalance(fromAct.getBalance()-money);
        toact.setBalance(toact.getBalance()+money);
        int count = accountMapper.update(fromAct);

        /*String s = null;
        s.toString();*/

        count += accountMapper.update(toact);
        if(count!=2){
            throw new RuntimeException("转账失败，原因未知！！！");
        }
        System.out.println("转账成功！！！");
    }
}
