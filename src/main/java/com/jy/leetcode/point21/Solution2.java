package com.jy.leetcode.point21;

/**
 * Created by Administrator on 2019/8/17.
 */
public class Solution2 {
    public double new21GameNLessThanW(int N, int K, int W) {
        if (K == 1) {
            return N / W;
        }
        Solution s = new Solution();
        double[] p = s.getP(W, W);
        double res = 0;
        double dwp = (double) 1 / W;
        for (int i = 1; i <= K; ++i) {
            res += p[i] * (i + (W - N)) * dwp;
        }
        return 1 - res;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
//        s.new21Game(21, 17, 10);
        s.new21GameNLessThanW(6, 1, 10);
    }
}
