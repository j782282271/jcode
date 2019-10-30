package com.jy.leetcode.water;

/**
 * Created by jiangyang on 2019/10/21.
 */
public class Water {
    public static void main(String[] args) {
        Water water = new Water();
        water.canMeasureWater(11, 3, 13);
        water.canMeasureWater(13, 11, 1);
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
            return inner(x, y, z);
        }
        return inner(y, x, z);
    }

    private boolean inner(int min, int max, int z) {
        int i;
        for (i = 1; ; ++i) {
            int base = i * min;
            if (base <= max) {
                if (base == z) {
                    //i*min==z
                    return true;
                } else if (max - base == z) {
                    //max-i*min==z
                    return true;
                } else if (max - base < min && max - base + max == z) {
                    return true;
                }
            } else {
                break;
            }
        }
        if (i * min == z) {
            return true;
        }
        if (i * min - max == z) {
            return true;
        }
        if (i * min - max <= min && i * min - max + min == z) {
            return true;
        }
        if (max - min <= min && max - min + max == z) {
            return true;
        }
        return inner1(min, max, z);
//        return false;
    }

    public boolean inner1(int min, int max, int z) {
        int base = max - min;
        int i = 0;
        for (; ; ++i) {
            if (z == i * base) {
                return true;
            } else if (i * base >= max) {
                break;
            }
        }
        if ((i - 1) * base - min == z) {
            return true;
        }
        return false;
    }
}
