package com.tsingkuo.webapp.springtransaction.dao;

public interface AccountDAO {

    /**
     *
     * @param username 钱款转出的用户名
     * @param money 转出的钱款数量
     */
    public void outAccount(String username, double money);

    /**
     *
     * @param username 钱款转入的用户名
     * @param money 转入的钱款数量
     */
    public void inAccount(String username, double money);
}
