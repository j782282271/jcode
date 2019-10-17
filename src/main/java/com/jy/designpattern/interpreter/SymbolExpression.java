package com.jy.designpattern.interpreter;

/**
 * Created by jiangyang on 2019/10/17.
 */
public abstract class SymbolExpression extends Expression {

    protected Expression left;

    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}