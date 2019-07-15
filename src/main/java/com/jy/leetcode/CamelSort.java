package com.jy.leetcode;

/**
 * 给定一个数字数组，在原数组中重新排序使数据满足 nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * 例如：nums = [3, 5, 2, 1, 6, 4], 一个可能的结果是 [1, 6, 2, 5, 3, 4]。
 * 这道题相邻的是可以相等的，相比较稍微简单一些；
 * 感兴趣也可以做下边这道leetcode的，相邻的不能相等
 * https://leetcode-cn.com/problems/wiggle-sort-ii/
 */
public class CamelSort {
    public static void main(String[] args) {
        int[] input = new int[]{3, 1, 5, 2, 1, 6, 4, 7, 20, 18, 13, 14, 1, 1, 2, 1, 0, 2};
        //int[] input = new int[]{3, 10, 55, 2};
        for (int i = 0, j = 1, k = 2; k < input.length; i = i + 2, j = j + 2, k = k + 2) {
            putMaxValueInMid(input, i, j, k);
        }
        //边界情况
        if (input.length % 2 == 0 && input[input.length - 1] < input[input.length - 2]) {
            exchange(input, input.length - 1, input.length - 2);
        }
        for (int i = 0; i < input.length; ++i) {
            System.out.print(input[i] + ",");
        }
    }

    //可以改为位运算，省掉o(1)的变量
    public static void exchange(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void putMaxValueInMid(int[] input, int low, int mid, int high) {
        if (input[low] > input[mid]) {
            exchange(input, low, mid);
        }
        if (input[high] > input[mid]) {
            exchange(input, mid, high);
        }
    }
}
