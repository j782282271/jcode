package com.jy.leetcode.zeroone;

/**
 * Created by jiangyang on 2019/9/3.
 * 背包问题：https://blog.csdn.net/u013885699/article/details/80248536
 */
public class Solution {
    private int[][][] res;

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
        int res = s.findMaxForm(strs, 5, 3);
//        Solution s = new Solution();
//        String[] strs = new String[]{"10", "0", "1"};
//        int res = s.findMaxForm(strs, 1, 1);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        res = new int[strs.length][m + 1][n + 1];
        for (int k = 0; k < strs.length; ++k) {
            int[] num01 = get01Num(strs[k]);
            for (int i = 0; i <= m; ++i) {
                for (int j = 0; j <= n; ++j) {
                    if (num01[0] <= i && num01[1] <= j) {
                        if (k == 0) {
                            res[k][i][j] = 1;
                            continue;
                        }
                        res[k][i][j] = Math.max(res[k - 1][i - num01[0]][j - num01[1]] + 1, res[k - 1][i][j]);
                    } else {
                        if (k == 0) {
                            res[k][i][j] = 0;
                            continue;
                        }
                        res[k][i][j] = res[k - 1][i][j];
                    }
                }
            }
        }
        return res[strs.length - 1][m][n];
    }

    private int[] get01Num(String str) {
        int[] res = new int[2];
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == '0') {
                res[0] += 1;
            } else {
                res[1] += 1;
            }
        }
        return res;
    }
}
