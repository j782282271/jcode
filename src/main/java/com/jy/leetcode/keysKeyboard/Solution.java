package com.jy.leetcode.keysKeyboard;

/**
 * Created by jiangyang on 2019/10/8.
 */
public class Solution {
    private int[] dp;

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.minSteps(6);
    }

    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 2;
        }
        dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 2;
        for (int i = 3; i <= n; ++i) {
            int c = getMinConvention(i);
            if (c != -1) {
                dp[i] = dp[i / c] + c;
            } else {
                dp[i] = i;
            }
        }
        return dp[n];
    }

    private int getMinConvention(int n) {
        int max = n / 2;
        for (int i = 2; i < max; ++i) {
            if (n % i == 0) {
                return i;
            }
        }
        return -1;
    }
}
