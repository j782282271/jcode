package com.jy.leetcode.maxLengthPairChain;

import java.util.Arrays;

/**
 * Created by jiangyang on 2019/9/25.
 */
public class Best {
    public static void main(String[] args) {
        Best s = new Best();
        int[][] pairs = new int[][]{{1, 2}, {2, 3}, {3, 4}};
        int res = s.findLongestChain(pairs);
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

        int result = 1;
        int lastMax = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > lastMax) {
                result++;
                lastMax = pairs[i][1];
            }
        }

        return result;
    }
}
