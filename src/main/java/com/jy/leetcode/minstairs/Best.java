package com.jy.leetcode.minstairs;

/**
 * Created by jiangyang on 2019/8/9.
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 */
class Best {

    public static void main(String[] args) {
        int[] input = new int[]{0, 0, 1, 1};
        Best s = new Best();
        int res = s.minCostClimbingStairs(input);
    }

    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 1) {
            return 0;
        }
        for (int i = 2; i < cost.length; ++i) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
}
