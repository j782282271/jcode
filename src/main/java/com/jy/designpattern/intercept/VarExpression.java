package com.jy.designpattern.intercept;

import java.util.HashMap;

/**
 * Created by jiangyang on 2019/10/17.
 */
public class VarExpression extends Expression {

    private String key;

    public VarExpression(String key){

        this.key = key;

    }

    @Override
    public int interceptor(HashMap<String, Integer> var) {
        return var.get(this.key);
    }

}
