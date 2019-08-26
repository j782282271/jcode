package com.jy.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jiangyang on 2019/8/7.
 */
public abstract class App implements BeanFactoryPostProcessor {
    public abstract Command abc();

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
        Command command = (Command) applicationContext.getBean("command");
        ConstructorTest constructorTest = (ConstructorTest) applicationContext.getBean("constructorTest1");

        Object o = applicationContext.getBean("&commandFactoryBean");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("App.postProcessBeanFactory");
    }
}
