package com.jy.designpattern.intercept;

import java.util.HashMap;

/**
 * Created by jiangyang on 2019/10/17.
 */
public class AddExpression extends SymbolExpression {

    public AddExpression(Expression left,Expression right){
        super(left,right);
    }

//把左右两个表达式运算的结果加起来

    @Override
    public int interceptor(HashMap<String, Integer> var) {
        return super.left.interceptor(var) + super.right.interceptor(var);
    }

}