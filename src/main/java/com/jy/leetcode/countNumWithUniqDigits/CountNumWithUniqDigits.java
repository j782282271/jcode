package com.jy.leetcode.countNumWithUniqDigits;

/**
 * Created by jiangyang on 2019/10/14.
 */
public class CountNumWithUniqDigits {

    private int[] dp = new int[10];

    public static void main(String[] args) {
        CountNumWithUniqDigits c = new CountNumWithUniqDigits();
        int res = c.countNumbersWithUniqueDigits(3);
    }

    public int countNumbersWithUniqueDigits(int n) {
        if (n > 10) {
            return 0;
        }
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            dp[i] = getThisBitsNum(i) + dp[i - 1];
        }
        return dp[n];
    }

    private int getThisBitsNum(int n) {
        if (n == 0) {
            return 1;
        }
        int res = 9;
        for (int i = 1; i < n; ++i) {
            res *= (10 - i);
        }
        return res;
    }
}
