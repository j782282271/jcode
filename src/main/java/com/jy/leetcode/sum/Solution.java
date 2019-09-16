package com.jy.leetcode.sum;

/**
 * Created by jiangyang on 2019/9/16.
 */
public class Solution {
    int[][] dp;
    private static int BASE_L = 1002;
    private static int L = BASE_L * 2;

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        Solution s = new Solution();
        int res = s.findTargetSumWays(nums, 3);

//        int[] nums = new int[]{1000};
//        Solution s = new Solution();
//        int res = s.findTargetSumWays(nums, 1000);
    }

    public int findTargetSumWays(int[] nums, int S) {
        if (S > 1000 || S < -1000) {
            return 0;
        }
        dp = new int[nums.length][L];
        dp[0][nums[0]] += 1;
        if (nums[0] == 0) {
            dp[0][nums[0]] += 1;
        }

        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j <= L; ++j) {
                if (j + nums[i] >= L) {
                    break;
                }
                //nums[i]前取负
                dp[i][j] = dp[i - 1][j + nums[i]];
                //nums[i]前取正
                int sum = j - nums[i];
                if (sum < 0) {
                    sum = -sum;
                }
                dp[i][j] += dp[i - 1][sum];
            }
        }
        return dp[nums.length - 1][Math.abs(S)];
    }

}