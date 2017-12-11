package com.tsingkuo.webapp.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MysqlUtilTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getConnection() throws Exception {
        Connection connection = MysqlUtil.getConnection();
        String sqlString = "select * from iterm";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlString);
//        while (resultSet.next()) {
//            System.out.println(resultSet.getInt("id"));
//        }
        Assert.assertTrue(resultSet.next());
    }

}