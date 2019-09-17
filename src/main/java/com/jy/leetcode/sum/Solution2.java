package com.jy.leetcode.sum;

/**
 * Created by jiangyang on 2019/9/16.
 */
public class Solution2 {
    int[][] dp;
    private static int BASE_L = 1002;
    private static int L = BASE_L * 2;

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        Solution2 s = new Solution2();
        int res = s.findTargetSumWays(nums, 3);

//        int[] nums = new int[]{1000};
//        Solution s = new Solution();
//        int res = s.findTargetSumWays(nums, 1000);
    }

    public int findTargetSumWays(int[] nums, int S) {
        if (S > 1000 || S < -1000) {
            return 0;
        }
        dp = new int[2][L];
        dp[0][nums[0]] += 1;
        if (nums[0] == 0) {
            dp[0][nums[0]] += 1;
        }

        int i = 1;
        for (i = 1; i < nums.length; ++i) {
            for (int j = 0; j <= L; ++j) {
                int iMod = i % 2;
                int iModPre = (i % 2) - 1 < 0 ? 1 : 0;
                if (j + nums[i] >= L) {
                    break;
                }
                //nums[i]前取负
                dp[iMod][j] = dp[iModPre][j + nums[i]];
                //nums[i]前取正
                int sum = j - nums[i];
                if (sum < 0) {
                    sum = -sum;
                }
                dp[iMod][j] += dp[iModPre][sum];
            }
        }
        return dp[(i % 2) - 1 < 0 ? 1 : 0][Math.abs(S)];
    }
}
