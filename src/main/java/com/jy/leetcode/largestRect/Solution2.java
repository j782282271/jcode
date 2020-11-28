package com.jy.leetcode.largestRect;

import java.util.*;

/**
 * Created by jiangyang on 2019/12/18.
 */
class Solution2 {
    private TreeMap<Integer, List<Integer>> h2i = new TreeMap<>();

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int res = solution2.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        for (int i = 0; i < heights.length; ++i) {
            h2i.putIfAbsent(heights[i], new ArrayList<>());
            h2i.get(heights[i]).add(i);
        }
        return largestRectangleAreaInner(0, heights.length);
    }

    private int largestRectangleAreaInner(Integer start, Integer end) {
        if (end <= start) {
            return 0;
        }
        Integer[] minHeightAndIndex = getMinHeightAndIndex(start, end);

        int maxArea = minHeightAndIndex[0] * (end - start);
        int maxAreaLeft = largestRectangleAreaInner(start, minHeightAndIndex[1]);
        int maxAreaRight = largestRectangleAreaInner(minHeightAndIndex[1] + 1, end);
        int res = Math.max(Math.max(maxArea, maxAreaLeft), maxAreaRight);
        return res;
    }

    private Integer[] getMinHeightAndIndex(int start, int end) {
        Integer[] res = new Integer[2];
        label:
        for (Map.Entry<Integer, List<Integer>> entry : h2i.entrySet()) {
            if (entry == null) {
                return null;
            }
            Iterator<Integer> iterator = entry.getValue().iterator();
            while (iterator.hasNext()) {
                Integer index = iterator.next();
                if (index >= start && index < end) {
                    res[0] = entry.getKey();
                    res[1] = index;
                    iterator.remove();
                    if (entry.getValue().size() == 0) {
                        h2i.remove(entry.getKey());
                    }
                    break label;
                }
            }
        }
        return res;
    }
}
