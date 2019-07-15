package com.jy.leetcode;

/**
 * 给定两个整数W和K，W代表你拥有的初始资金，K代表你最多可以做K个项目。再给定两个长度为N的正整数数组costs[]和profits[]，代表一共有N个项目，costs[i]和profits[i]分别表示第i号项目的启动资金与做完后的利润（注意是利润，如果一个项目的启动资金是10，利润为4，代表该项目最终的收入是14）。你不能并行只能串行的做项目，并且手里拥有的资金大于或等于某个项目的启动资金时，你才能做这个项目（每个项目只能做一次）。该如何选择做项目，能让你最终的收益最大？返回最后能够获得的最大资金。
 * 【举例】
 * W = 3
 * K = 2
 * costs = {5, 4, 1, 2}
 * profits = {3, 5, 3, 2}
 * 输出：11
 * 【时间复杂度】
 * O(NlogN)
 */
public class Profits {

    private int initMoney;

    private int maxProjectCount;

    private int[] projectCosts;

    private int[] projectProfits;

    public Profits(int initMoney, int maxProjectCount, int[] projectCosts, int[] projectProfits) {
        this.initMoney = initMoney;
        this.maxProjectCount = maxProjectCount;
        this.projectCosts = projectCosts;
        this.projectProfits = projectProfits;
    }

    public static void main(String[] args) {
        Profits profits = new Profits(3, 2, new int[]{5, 4, 1, 2}, new int[]{3, 5, 3, 2});
        System.out.println(profits.maxMoney());
    }

    public int maxMoney() {
        //不考虑可做项目数大于总项目数的边界情况
        int currentMaxMoney = initMoney;
        while (maxProjectCount > 0) {
            int currentOriginMoney = currentMaxMoney;
            int pickedIndex = -1;
            for (int i = 0; i < projectCosts.length; ++i) {
                if (currentOriginMoney >= projectCosts[i]) {
                    if (currentMaxMoney < currentOriginMoney + projectProfits[i]) {
                        currentMaxMoney = currentOriginMoney + projectProfits[i];
                        pickedIndex = i;
                    }
                }
            }
            if (pickedIndex == -1) {
                break;
            }
            projectCosts[pickedIndex] = Integer.MAX_VALUE;
            --maxProjectCount;
        }
        return currentMaxMoney;
    }
}
