package com.jy.leetcode;

/**
 * Created by jiangyang on 2019/11/15.
 */
public class FinallyTest {
    public void FinallyTest() {
        System.out.println("FinallyTest");
    }

    public static void main(String args[]) {
        FinallyTest t = new FinallyTest();
        int b = t.get();
        t.FinallyTest();
        System.out.println(b);
    }

    public int get() {
        try {
            return 1;
        } finally {
            return 2;
        }
    }
}
