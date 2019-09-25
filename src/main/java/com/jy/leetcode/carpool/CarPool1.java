package com.jy.leetcode.carpool;

/**
 * Created by jiangyang on 2019/7/15.
 * https://leetcode-cn.com/problems/car-pooling/
 * 5ms       81.66%
 * 36.1MB    1000%
 * 问题受限于1000大小限制
 */
public class CarPool1 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] res = new int[1000];
        for (int i = 0; i < trips.length; ++i) {
            for (int j = trips[i][1]; j < trips[i][2]; ++j) {
                res[j] += trips[i][0];
                if (capacity < res[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
