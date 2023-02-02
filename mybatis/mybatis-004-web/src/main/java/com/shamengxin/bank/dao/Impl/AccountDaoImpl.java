package com.shamengxin.bank.dao.Impl;

import com.shamengxin.bank.dao.AccountDao;
import com.shamengxin.bank.pojo.Account;
import com.shamengxin.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountDaoImpl implements AccountDao {
    @Override
    public Account selectByActno(String actno) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Account account = (Account) sqlSession.selectOne("account.selectByActno", actno);
        sqlSession.close();
        return account;
    }

    @Override
    public int updateByActno(Account act) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.update("account.updateByActno", act);
        sqlSession.commit();
        sqlSession.close();
        return count;
    }
}
