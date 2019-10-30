package com.jy.leetcode.water;

/**
 * Created by jiangyang on 2019/10/22.
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution a = new Solution();
        boolean res = a.canMeasureWater(34, 5, 6);
        res = a.canMeasureWater(11, 13, 1);
        res = a.canMeasureWater(11, 13, 5);
        res = a.canMeasureWater(2, 6, 5);
        res = a.canMeasureWater(22003, 31237, 1);
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) {
            return true;
        }
        if (x == 0) {
            return y == z;
        }
        if (y == 0) {
            return x == z;
        }
        if (z > x + y) {
            return false;
        }
        if (z == x || z == y || z == x + y) {
            return true;
        }
        if (x == y) {
            return false;
        }

        int min = Math.min(x, y);
        int max = Math.max(x, y);
//        for(){}
        return false;
    }

}
