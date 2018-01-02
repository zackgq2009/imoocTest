package com.tsingkuo.webapp.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class webApplicationContextAware implements ApplicationContextAware, BeanNameAware{

    private String name;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext:" + applicationContext.getBean(this.name).hashCode());
    }

    public void setBeanName(String name) {
        this.name = name;
        System.out.println("setBeanName:" + name);
    }
}