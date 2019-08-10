package com.jy.leetcode.minstairs;

/**
 * Created by jiangyang on 2019/8/9.
 */
class Solution2 {

    public static void main(String[] args) {
        int[] input = new int[]{0, 0, 1, 1};
        Solution2 s = new Solution2();
        int res = s.minCostClimbingStairs(input);
    }

    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 1) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < cost.length; ++i) {
            res = res + Math.min(cost[i+1],);
        }
    }
}
