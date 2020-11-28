package com.jy.leetcode.largestRect;

/**
 * Created by jiangyang on 2019/12/18.
 */
class Solution {
    private int[] heights;

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        this.heights = heights;
        return largestRectangleAreaInner(0, heights.length);
    }

    private int largestRectangleAreaInner(int start, int end) {
        if (end <= start) {
            return 0;
        }
        int minI = 0;
        int minHeight = Integer.MAX_VALUE;
        for (int i = start; i < end; ++i) {
            if (minHeight >= heights[i]) {
                minHeight = heights[i];
                minI = i;
            }
        }
        int maxArea = minHeight * (end - start);
        int maxAreaLeft = largestRectangleAreaInner(start, minI);
        int maxAreaRight = largestRectangleAreaInner(minI + 1, end);
        int res = Math.max(Math.max(maxArea, maxAreaLeft), maxAreaRight);
        return res;
    }
}
