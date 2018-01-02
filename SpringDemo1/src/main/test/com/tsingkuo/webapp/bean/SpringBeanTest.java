package com.tsingkuo.webapp.bean;

import com.tsingkuo.webapp.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(BlockJUnit4ClassRunner.class)
public class SpringBeanTest extends UnitTestBase {

    public SpringBeanTest() {
        super("classpath*:spring-bean.xml");
    }

    @Test
    public void testSpringBean() {
        super.getBean("springBean");
    }
}