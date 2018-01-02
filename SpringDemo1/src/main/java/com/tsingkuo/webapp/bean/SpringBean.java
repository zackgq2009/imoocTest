package com.tsingkuo.webapp.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class SpringBean implements InitializingBean, DisposableBean {

    public void destroy() throws Exception {
        System.out.println("重写方法中的destroy");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("重写方法中的init");
    }

    public void beanAfterPropertiesSet() throws Exception{
        System.out.println("bean标签中定义的init-method");
    }

    public void beanDestroy() throws Exception{
        System.out.println("bean标签中定义的destroy-method");
    }

    public void defaultAfterPropertiesSet() throws Exception{
        System.out.println("beans标签下定义的全局默认init");
    }

    public void defaultDestroy() throws Exception {
        System.out.println("beans标签下定义的全局默认destroy");
    }
}
