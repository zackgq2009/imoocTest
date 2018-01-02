package com.tsingkuo.webapp.springtransaction.service;

import com.tsingkuo.webapp.springtransaction.dao.AccountDAO;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class AccountServiceImpl implements AccountService {

    private AccountDAO accountDAO;

    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void transferAccounts(final String outUsername, final String inUsername, final double money) {
//        accountDAO.outAccount(outUsername, money);
////        int d = 1/0;
//        accountDAO.inAccount(inUsername, money);

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                accountDAO.outAccount(outUsername, money);
                int d = 1/0;
                accountDAO.inAccount(inUsername, money);
            }
        });

    }
}
