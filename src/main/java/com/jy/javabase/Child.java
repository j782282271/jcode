package com.jy.javabase;

/**
 * Created by jiangyang on 2019/11/15.
 */
public class Child extends Sup {
    //    public void ss(){
//Cannot override a static method by an instance method
//    }
    @Override
    public void a() {

        //子类重写父类的方法，访问权限不能降低
    }
}
