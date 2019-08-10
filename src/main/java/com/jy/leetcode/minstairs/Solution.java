package com.jy.leetcode.minstairs;

/**
 * Created by jiangyang on 2019/8/9.
 */
class Solution {

    public static void main(String[] args) {
        int[] input = new int[]{0, 0, 1, 1};
        Solution s = new Solution();
        int res = s.minCostClimbingStairs(input);
    }

    public int minCostClimbingStairs(int[] cost) {
        if (cost == null) {
            return 0;
        }
        return minCostClimbingStairs(cost, cost.length);
    }

    public int minCostClimbingStairs(int[] cost, int end) {
        if (end == 1) {
            return cost[0];
        }
        if (end == 2) {
            return cost[1];
        }
        if (end == 3) {
            return Math.min(cost[0] + cost[2], cost[1] + cost[2]);
        }

        int v1 = minCostClimbingStairs(cost, end - 2);
        int res = Math.min(v1 + cost[end - 2], v1 + cost[end - 1]);

        int v2 = minCostClimbingStairs(cost, end - 1);
        return Math.min(res, v2);
    }
}
