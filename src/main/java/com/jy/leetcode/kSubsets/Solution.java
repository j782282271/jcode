package com.jy.leetcode.kSubsets;

/**
 * Created by jiangyang on 2019/12/24.
 */
class Solution {

    private int[] nums;
    private int avg;
    private int foundCount = 0;

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean res = s.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4);
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        avg = sum / k;
        if (sum % k != 0 || max > avg) {
            return false;
        }
        this.nums = nums;
        return canPartitionKSubsetsInner(avg);
    }

    public boolean canPartitionKSubsetsInner(int remain) {
        if (foundCount == nums.length) {
            return true;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (remain < nums[i]) {
                continue;
            }
            int backupNum = nums[i];
            remain -= nums[i];
            nums[i] = Integer.MAX_VALUE;
            foundCount++;
            boolean subRes = canPartitionKSubsetsInner(remain == 0 ? avg : remain);
            if (subRes == false) {
                foundCount--;
                nums[i] = backupNum;
                remain += backupNum;
            }
        }

        if (foundCount == nums.length) {
            return true;
        }
        return false;
    }

}