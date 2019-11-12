package com.jy.leetcode.friendCircles;

/**
 * Created by jiangyang on 2019/11/12.
 */
class Solution {
    private int[][] m;

    public static void main(String[] args) {
        int[][] M = new int[][]{
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}};
        Solution solution = new Solution();
        int res = solution.findCircleNum(M);
    }

    public int findCircleNum(int[][] M) {
        m = M;
        int res = 0;
        for (int i = 0; i < M.length; ++i) {
            if (visit(i, M[i])) {
                res++;
            }
        }
        return res;
    }

    private boolean visit(int i, int[] friends) {
        boolean contains1 = false;
        for (int j = 0; j < friends.length; ++j) {
            if (friends[j] == 1) {
                friends[j] = 0;
                visit(j, m[j]);
                contains1 = true;
            }
        }
        return contains1;
    }
}
