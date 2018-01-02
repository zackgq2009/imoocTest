package com.tsingkuo.webapp.springtransaction3.service;

import com.tsingkuo.webapp.springtransaction3.dao.AccountDAO;

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
