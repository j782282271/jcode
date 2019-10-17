package com.jy.designpattern.intercept;

import java.util.HashMap;

/**
 * Created by jiangyang on 2019/10/17.
 */
public class SubExpression extends SymbolExpression {

    public SubExpression(Expression left,Expression right){
        super(left,right);
    }

    @Override
    public int interceptor(HashMap<String, Integer> var) {
        return super.left.interceptor(var) - super.right.interceptor(var);
    }

}
