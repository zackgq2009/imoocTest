package com.tsingkuo.webapp.springtransaction4.service;

import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    /**
     *
     * @param outUsername 转出的用户名
     * @param inUsername 转入的用户
     * @param money 转账钱款的数量
     */
    public void transferAccounts(String outUsername, String inUsername, double money);
}
