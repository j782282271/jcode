package com.jy.leetcode.sum;

/**
 * Created by jiangyang on 2019/9/17.
 */
public class DiGui {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        DiGui s = new DiGui();
        int res = s.findTargetSumWays(nums, 3);
    }

    public int findTargetSumWays(int[] nums, int S) {
        return findInner(nums, 0, S);
    }

    public int findInner(int[] nums, int curr, int s) {
        if (curr == nums.length) {
            if (s == 0) {
                return 1;
            }
            return 0;
        }
        int pos = findInner(nums, curr + 1, s - nums[curr]);
        int neg = findInner(nums, curr + 1, s + nums[curr]);
        return pos + neg;
    }
}
