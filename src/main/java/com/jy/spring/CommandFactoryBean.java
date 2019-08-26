package com.jy.spring;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by jiangyang on 2019/8/16.
 */
public class CommandFactoryBean implements FactoryBean<Command> {
    @Override
    public Command getObject() throws Exception {
        return new Command();
    }

    @Override
    public Class<?> getObjectType() {
        return Command.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
