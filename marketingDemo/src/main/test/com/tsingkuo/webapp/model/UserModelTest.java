package com.tsingkuo.webapp.model;

import com.tsingkuo.webapp.entity.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class UserModelTest {
    UserModel userModel = null;
    User user = null;

    @Before
    public void setUp() throws Exception {
        userModel = new UserModel();
        user = new User();
        user.setId(5);
        user.setUsername("admin");
        user.setPassword("admin");
        user.setGender("male");
        user.setAge((byte) 30);
    }

    @After
    public void tearDown() throws Exception {
//        UserModelTest userModelTest = new UserModelTest();
//        userModelTest.delUser();
    }

    @Test
    public void createUser() throws Exception {
        Assert.assertFalse(userModel.createUser(user));
    }

    @Test
    public void queryUser() throws Exception {
        Collection<User> userCollection = userModel.queryUser();
        Assert.assertNotNull(userCollection);
        Assert.assertTrue(userCollection.size()>0);
    }

    @Test
    public void queryUser1() throws Exception {
        Assert.assertNotNull(userModel.queryUser(user.getId()));
    }

    @Test
    public void updateUser() throws Exception {
        user.setUsername("asdfasdf");
        user.setPassword("asdfasdf");
        Assert.assertFalse(userModel.updateUser(user));
    }

    @Test
    public void searchUser() throws Exception {
        user.setUsername("asdfasdf");
        user.setPassword("asdfasdf");
        Assert.assertNotNull(userModel.searchUser("asdfasdf"));
    }

    @Test
    public void delUser() throws Exception {
        user.setId(13);
        Assert.assertFalse(userModel.delUser(user));
    }

}