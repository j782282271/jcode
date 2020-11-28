package com.jy.leetcode.largestRect;

/**
 * Created by jiangyang on 2019/12/18.
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int res = s.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }

        int preLeft = heights[0];
        for (int i = 1; i < heights.length; ++i) {
            if (heights[i] >= heights[i - 1]) {
                preLeft = Math.max(preLeft + heights[i - 1], heights[i]);
            }
        }

        int preRight = heights[heights.length - 1];
        for (int i = heights.length - 2; i >= 0; --i) {
            if (heights[i] >= heights[i + 1]) {
                preRight = Math.max(preRight + heights[i + 1], heights[i]);
            }
        }
        return Math.max(preLeft, preRight);
    }
}
