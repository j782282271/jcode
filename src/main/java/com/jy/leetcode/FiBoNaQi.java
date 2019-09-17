package com.jy.leetcode;

/**
 * Created by jiangyang on 2019/9/17.
 */
public class FiBoNaQi {
    //1 1 2 3 5 8 13 21
    public static void main(String[] args) {
        int i = cal(3);
        System.out.println(i);

        i = cal(5);
        System.out.println(i);
    }

    public static int cal(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return cal(n - 1) + cal(n - 2);
    }
}
