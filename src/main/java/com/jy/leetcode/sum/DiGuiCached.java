package com.jy.leetcode.sum;

import java.util.Arrays;

/**
 * Created by jiangyang on 2019/9/17.
 */
public class DiGuiCached {
    private static int BASE_L = 1002;
    private static int L = BASE_L * 2;

    private int[][] cached;

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        DiGuiCached s = new DiGuiCached();
        int res = s.findTargetSumWays(nums, 3);
    }

    public int findTargetSumWays(int[] nums, int S) {
        if (S > 1000 || S < -1000) {
            return 0;
        }
        cached = new int[nums.length][L];
        for (int i = 0; i < cached.length; ++i) {
            Arrays.fill(cached[i], -1);
        }
        return findInner(nums, 0, S);
    }

    public int findInner(int[] nums, int curr, int s) {
        if (curr == nums.length) {
            if (s == 0) {
                return 1;
            }
            return 0;
        }
        if (cached[curr][Math.abs(s)] != -1) {
            return cached[curr][Math.abs(s)];
        }
        int pos = findInner(nums, curr + 1, s - nums[curr]);
        int neg = findInner(nums, curr + 1, s + nums[curr]);
        cached[curr][Math.abs(s)] = pos + neg;
        return pos + neg;
    }
}
