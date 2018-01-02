package com.tsingkuo.webapp.springtransaction2.service;

import com.tsingkuo.webapp.springtransaction2.dao.AccountDAO;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

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
