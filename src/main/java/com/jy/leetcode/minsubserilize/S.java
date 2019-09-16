package com.jy.leetcode.minsubserilize;

/**
 * Created by jiangyang on 2019/9/12.
 */
public class S {
    private int result = 1;

    public static void main(String[] args) {
        int nums[] = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        S solution = new S();
        int res = solution.lengthOfLIS(nums);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        lengthOfLISHelper(nums, nums.length);

        return result;
    }

    private int lengthOfLISHelper(int[] nums, int n) {
        if (n <= 1) {
            return n;
        }

        int max = 1;
        for (int i = 1; i < n; ++i) {
            int tmp = lengthOfLISHelper(nums, i);
            if (nums[i - 1] < nums[n - 1] && tmp + 1 > max) {
                max = tmp + 1;
            }
        }

        if (max > result) {
            result = max;
        }

        return max;
    }
}
