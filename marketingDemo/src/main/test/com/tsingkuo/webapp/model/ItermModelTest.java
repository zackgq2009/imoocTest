package com.tsingkuo.webapp.model;

import com.tsingkuo.webapp.entity.Iterm;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItermModelTest {
    ItermModel itermModel = null;
    Iterm iterm = null;

    @Before
    public void setUp() throws Exception {
        itermModel = new ItermModel();
        iterm = new Iterm();
        iterm.setId(5);
        iterm.setItermName("日本进口tenga egg自慰蛋飞机杯男用飞机蛋 自慰器情趣成人用品");
        iterm.setItermPrice(39);
        iterm.setItermStock(10000);
        iterm.setItermDescription("日本进口tenga egg自慰蛋飞机杯男用飞机蛋 自慰器情趣成人用品");
        iterm.setItermPicture("images/005.jpg");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createIterm() throws Exception {
    }

    @Test
    public void delIterm() throws Exception {
    }

    @Test
    public void updateIterm() throws Exception {
    }

    @Test
    public void queryIterm() throws Exception {
        Assert.assertNotNull(itermModel.queryIterm());
        Assert.assertTrue(itermModel.queryIterm().size()>0);
    }

    @Test
    public void queryIterm1() throws Exception {
        Assert.assertNotNull(itermModel.queryIterm(iterm.getId()));
    }

    @Test
    public void searchIterm() throws Exception {
        System.out.println(itermModel.searchIterm(iterm.getItermName()));
        Assert.assertNotNull(itermModel.searchIterm(iterm.getItermName()));
    }

}