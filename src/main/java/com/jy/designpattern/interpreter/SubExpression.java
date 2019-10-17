package com.jy.designpattern.interpreter;

import java.util.HashMap;

/**
 * Created by jiangyang on 2019/10/17.
 */
public class SubExpression extends SymbolExpression {

    public SubExpression(Expression left,Expression right){
        super(left,right);
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) - super.right.interpreter(var);
    }

}
