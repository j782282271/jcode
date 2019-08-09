package com.jy.leetcode.minstairs;

/**
 * Created by jiangyang on 2019/8/9.
 */
class Solution {

    public int minCostClimbingStairs(int[] cost) {
        if (cost == null) {
            return 0;
        }
        return minCostClimbingStairs(cost, cost.length);
    }

    public int minCostClimbingStairs(int[] cost, int end) {
        if (end <= 1) {
            return 0;
        }
        if (end == 2) {
            return Math.min(cost[0], cost[1]);
        }
        if (end == 3) {
            return Math.min(cost[0] + cost[2], cost[1]);
        }
        int v1 = minCostClimbingStairs(cost, end - 2);
        int v2 = minCostClimbingStairs(cost, end - 1);
        return Math.min(v1 + cost[end - 1], v2);
    }
}
