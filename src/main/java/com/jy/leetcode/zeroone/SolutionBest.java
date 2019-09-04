package com.jy.leetcode.zeroone;

/**
 * Created by jiangyang on 2019/9/4.
 */
public class SolutionBest {
    private int[][][] res;

    public static void main(String[] args) {
        SolutionBest s = new SolutionBest();
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
        int res = s.findMaxForm(strs, 5, 3);
//        Solution s = new Solution();
//        String[] strs = new String[]{"10", "0", "1"};
//        int res = s.findMaxForm(strs, 1, 1);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        if (strs.length == 0) {
            return 0;
        }

        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeroes = 0, ones = 0;

            for (int i = 0; i < str.length(); ++i) {
                if (str.charAt(i) == '0') {
                    ++zeroes;
                } else {
                    ++ones;
                }
            }

            for (int j = m; j >= zeroes; --j) {
                for (int k = n; k >= ones; --k) {
                    dp[j][k] = Math.max(dp[j][k], 1 + dp[j - zeroes][k - ones]);
                }
            }
        }
        return dp[m][n];
    }

}
