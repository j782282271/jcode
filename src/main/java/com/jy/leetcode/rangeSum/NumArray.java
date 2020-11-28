package com.jy.leetcode.rangeSum;

/**
 * Created by jiangyang on 2019/12/30.
 */
class NumArray {
    private int[] startEndNums;
    private int[] originNums;

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        int res = numArray.sumRange(0,2);
        numArray.update(1,2);
        res = numArray.sumRange(0,2);

    }

    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        this.originNums = nums;
        this.startEndNums = new int[originNums.length];
        this.startEndNums[0] = originNums[0];
        for (int i = 1; i < originNums.length; ++i) {
            this.startEndNums[i] = this.startEndNums[i - 1] + originNums[i];
        }

    }

    public void update(int i, int val) {
        if (originNums == null) {
            return;
        }
        int deta = val - originNums[i];
        originNums[i] = val;

        for (int j = i; j < originNums.length; ++j) {
            startEndNums[j] = startEndNums[j] + deta;
        }
    }

    public int sumRange(int i, int j) {
        if (originNums == null) {
            return 0;
        }
        return startEndNums[j] - startEndNums[i] + originNums[i];
    }
}

