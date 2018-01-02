package com.tsingkuo.webapp.springtransaction2.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springTransaction2.xml")
public class AccountServiceImplTest {

//    @Resource(name = "accountService")
    @Resource(name = "transactionProxyFactoryBean")
    public AccountService accountService;

    @Test
    public void transferAccounts() throws Exception {
        accountService.transferAccounts("aaa", "bbb", 200d);
    }

}