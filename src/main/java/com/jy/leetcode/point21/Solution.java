package com.jy.leetcode.point21;

/**
 * Created by Administrator on 2019/8/17.
 * https://leetcode-cn.com/problems/new-21-game/
 */
class Solution {
    public double new21Game(int N, int K, int W) {
        if (N == 0) {
            if (K == 0) {
                return 1;
            }
            return 0;
        }
        if (K == 0) {
            return N > W ? 0 : 1;
        }
        if (N >= W + K) {
            return 1;
        }
        if (N < W) {
            return new21GameNLessThanW(N, K, W);
        }
        //原来第二个参数填N,优化后改为K
        double[] p = getP(W, K);
        double res = 0;
        double dwp = (double) 1 / W;
        int start = (N - W + 1);
        //倒数第二次的各种可能加上最后一次超出的概率
        for (int i = start; i < K; ++i) {
            res += p[i] * (i - start + 1) * dwp;
        }
        //减去超出的概率就是没超出的概率
        return 1 - res;
    }

    public double new21GameNLessThanW(int N, int K, int W) {
        //原来第二个参数填W,优化后改为K
        double[] p = getP(W, K);
        double res = 0;
        double dwp = (double) 1 / W;
        //倒数第二次的各种可能加上最后一次超出的概率
        for (int i = 1; i < K; ++i) {
            res += p[i] * (i + (W - N)) * dwp;
        }
        //直接超出的概率
        res += (double) (W - N) / (double) W;
        //减去超出的概率就是没超出的概率
        return 1 - res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        s.new21Game(21, 17, 10);
        s.new21Game(6, 1, 10);
        double[] res = getP(10, 10);
    }

    //其实大于w小于n部分降精度了
    public static double[] getP(int w, int n) {
        double[] res = new double[n + 1];
        double dwp = (double) 1 / w;
        for (int i = 1; i < res.length; ++i) {
            double currentP = 0;
            for (int j = Math.max(i - w, 0); j < i; ++j) {
                currentP += res[j];
            }
            currentP *= dwp;
            if (i <= w) {
                currentP = currentP + dwp;
            }
            res[i] = currentP;
        }
        return res;
    }
}