package com.tsingkuo.webapp.springtransaction4.service;

import com.tsingkuo.webapp.springtransaction4.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

    private AccountDAO accountDAO;

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void transferAccounts(String outUsername, String inUsername, double money) {
        accountDAO.outAccount(outUsername, money);
        int d = 1 / 0;
        accountDAO.inAccount(inUsername, money);
    }
}
