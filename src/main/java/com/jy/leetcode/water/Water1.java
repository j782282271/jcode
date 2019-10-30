package com.jy.leetcode.water;

/**
 * Created by jiangyang on 2019/10/21.
 */
public class Water1 {
    public static void main(String[] args) {
        Water1 water1 = new Water1();
//        boolean res = water1.canMeasureWater(34, 5, 6);
//        boolean res = water1.canMeasureWater(11, 13, 1);
//        boolean res = water1.canMeasureWater(11, 13, 5);
//        res = water1.canMeasureWater(2, 6, 5);
        boolean res = water1.canMeasureWater(22003, 31237, 1);
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
        if (x < y) {
            return canMeasureWaterMM(x, y, z);
        }
        return canMeasureWaterMM(y, x, z);
    }

    boolean canMeasureWaterMM(int min, int max, int z) {
        int i;
        for (i = 0; ; ++i) {
            if (canMeasureWaterInner(min, max, z, i)) {
                return true;
            }
            if (i * min > max) {
                return false;
            }
        }
    }

    boolean canMeasureWaterInner(int min, int max, int z, int deviate) {
        int base = max - min;
        int i;
        int curr;
        for (i = 0; ; ++i) {
            curr = i * base - deviate * min;
            if (curr > max) {
                break;
            }
            if (canMeasureWaterD(min, max, z, curr)) {
                return true;
            }
        }

        base = min - max;
        for (i = 0; ; ++i) {
            curr = i * base + deviate * min;
            if (curr < 0) {
                break;
            }
            if (canMeasureWaterD(min, max, z, curr)) {
                return true;
            }
        }

        int beishu = max / min + 1;
        base = beishu * min - max;
        return canMeasureWaterD(min, max, z, base);
    }

    boolean canMeasureWaterD(int min, int max, int z, int curr) {
        if (curr > max || curr <= 0) {
            return false;
        }
        if (z == curr) {
            //大杯减小杯curr
            return true;
        } else if (curr + min == z || min - (max - curr) == z || curr - min == z) {
            //curr在大杯中
            return true;
        } else if (curr <= min && (curr + max == z || max - (min - curr) == z)) {
            //curr可以在小杯中，且在小杯中
            return true;
        }
        return false;
    }

}
