package com.tsingkuo.webapp.aware;

import com.tsingkuo.webapp.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(BlockJUnit4ClassRunner.class)
public class webApplicationContextAwareTest extends UnitTestBase{

    public webApplicationContextAwareTest() {
        super("classpath:spring-aware.xml");
    }

    @Test
    public void testWebApplicationContextAware() {
        System.out.println("testApplicationContextAware:" + super.getBean("webApplicationContextAware").hashCode());
    }
}