package com.jy.leetcode.maxLengthPairChain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jiangyang on 2019/9/24.
 */
public class SolutionCached {
    private int[] cached;

    public static void main(String[] args) {
        int[][] pairs = new int[][]{{1, 2}, {2, 3}, {3, 4}};
        SolutionCached s = new SolutionCached();
        int res = s.findLongestChain(pairs);
    }

    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        pairs = sortAndFilter(pairs);
        cached = new int[pairs.length + 1];
        return findLongestChainInner(pairs, pairs.length);
    }

    private int findLongestChainInner(int[][] pairs, int n) {
        if (n == 1) {
            return 1;
        }
        if (cached[n] != 0) {
            return cached[n];
        }

        int max = 1;
        for (int i = 1; i < n; ++i) {
            int iMaxSize = findLongestChainInner(pairs, i);
            if (pairs[i - 1][1] < pairs[n - 1][0] && iMaxSize + 1 > max) {
                max = iMaxSize + 1;
            }
        }
        cached[n] = max;
        return max;
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
