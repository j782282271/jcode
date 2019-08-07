package com.jy.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jiangyang on 2019/8/7.
 */
public abstract class App {
    public abstract Command abc();

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
    }
}
