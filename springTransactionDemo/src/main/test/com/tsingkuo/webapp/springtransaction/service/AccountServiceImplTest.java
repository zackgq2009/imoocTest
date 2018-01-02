package com.tsingkuo.webapp.springtransaction.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springTransaction.xml")
public class AccountServiceImplTest {

    @Resource(name = "accountService")
    public AccountServiceImpl accountService;

    @Test
    public void transferAccounts(){
        accountService.transferAccounts("aaa", "bbb", 200d);
    }

}