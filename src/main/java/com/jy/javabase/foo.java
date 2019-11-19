package com.jy.javabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiangyang on 2019/11/15.
 */
public class foo {
    public foo(String a) {

    }

    public foo() {
        int i = 0;
        //必须在第一行
//        this("sfda");
    }

    public static void main(String[] args) {
//        String s;
//        编译不通过：尚未初始化变量s
//        System.out.println("s=" + s);


    }

    public static int a(int a, int b) {
        try {
            return a + b;
        } catch (Exception e) {

        } finally {

        }
        return 0;
    }


}
