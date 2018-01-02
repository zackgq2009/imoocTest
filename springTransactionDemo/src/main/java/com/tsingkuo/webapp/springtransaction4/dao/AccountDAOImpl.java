package com.tsingkuo.webapp.springtransaction4.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("accountDAO")
public class AccountDAOImpl extends JdbcDaoSupport implements AccountDAO {
    public void outAccount(String username, double money) {
//        Class.forName("com.")
        String sql = "update account set money = money-? where name = ?";
        this.getJdbcTemplate().update(sql, money, username);
    }

    public void inAccount(String username, double money) {
        String sql = "update account set money = money+? where name = ?";
        this.getJdbcTemplate().update(sql, money, username);
    }

}
