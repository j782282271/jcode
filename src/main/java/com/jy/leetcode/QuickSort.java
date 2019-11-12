package com.jy.leetcode;

/**
 * Created by jiangyang on 2019/11/8.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] in = new int[]{9, 1, 10, 33, 3, 9, 46, 2, 0, 5};
        QuickSort sort = new QuickSort();
        sort.sort(in);
    }

    public void sort(int[] input) {
        sort(input, 0, input.length - 1);
    }

    public void sort(int[] input, int low, int high) {
        if (low >= high) {
            return;
        }
        int k = input[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (i < j && input[j] > k) {
                --j;
            }
            while (i < j && input[i] <= k) {
                ++i;
            }
            if (i < j) {
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
            }
        }
        input[low] = input[i];
        input[i] = k;

        sort(input, low, i - 1);
        sort(input, i + 1, high);
    }
}
