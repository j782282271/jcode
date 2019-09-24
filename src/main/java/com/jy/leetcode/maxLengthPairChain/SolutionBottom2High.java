package com.jy.leetcode.maxLengthPairChain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jiangyang on 2019/9/24.
 */
public class SolutionBottom2High {
    private int[] dp;

    public static void main(String[] args) {
        int[][] pairs = new int[][]{{-10, -8}, {8, 9}, {-5, 0}, {6, 10}, {-6, -4}, {1, 7}, {9, 10}, {-4, 7}};
        SolutionBottom2High s = new SolutionBottom2High();
        int res = s.findLongestChain(pairs);
//        int[][] pairs = new int[][]{{1, 2}, {2, 3}, {3, 4}};
//        SolutionBottom2High s = new SolutionBottom2High();
//        int res = s.findLongestChain(pairs);
    }

    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        pairs = sortAndFilter(pairs);
        dp = new int[pairs.length];
        return findLongestChainInner(pairs);
    }

    private int findLongestChainInner(int[][] pairs) {
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < pairs.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (pairs[i][0] > pairs[j][1] && max < dp[j] + 1) {
                    max = dp[j] + 1;
                }
            }
            dp[i] = max;
        }
        return dp[pairs.length - 1];
    }


    private int[][] sortAndFilter(int[][] pairs) {
        Arrays.sort(pairs, (o1, o2) -> o1[0] < o2[0] ? -1 : 1);

        Set<int[]> removeAble = new HashSet<>();
        int[] pre = pairs[0];
        for (int i = 1; i < pairs.length; ++i) {
            if (pairs[i][0] != pre[0]) {
                pre = pairs[i];
                continue;
            }
            if (aIncludeB(pre, pairs[i])) {
                removeAble.add(pre);
                pre = pairs[i];
            } else if (aIncludeB(pairs[i], pre)) {
                removeAble.add(pairs[i]);
            }
        }

        int[][] res = new int[pairs.length - removeAble.size()][2];
        int j = 0;
        for (int i = 0; i < pairs.length; ++i) {
            if (!removeAble.contains(pairs[i])) {
                res[j++] = pairs[i];
            }
        }
        return res;
    }

    private boolean aIncludeB(int[] a, int[] b) {
        if (a[1] >= b[1] && a[0] <= b[0]) {
            return true;
        }
        return false;
    }
}
