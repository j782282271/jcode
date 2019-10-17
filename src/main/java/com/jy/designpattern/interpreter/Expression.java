package com.jy.designpattern.interpreter;

import java.util.HashMap;

/**
 * Created by jiangyang on 2019/10/17.
 */
public abstract class Expression {
    /**
     * 解析公式和数值,其中var中的key值是是公式中的参数，value值是具体的数字
     * HashMap相当于context
     */
    public abstract int interpreter(HashMap<String, Integer> var);
}