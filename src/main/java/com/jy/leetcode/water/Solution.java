package com.jy.leetcode.water;

/**
 * Created by jiangyang on 2019/10/22.
 */
public class Solution {
    public static void main(String[] args) {
        Solution a = new Solution();
        boolean res = a.canMeasureWater(11, 13, 1);
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if (x == y && x == z) return true;

        if (z > x + y) return false;

        int gcd = gcd(x, y);
        if (z % gcd != 0) {
            return false;
        }

        return true;
    }

    public int gcd(int a,int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
