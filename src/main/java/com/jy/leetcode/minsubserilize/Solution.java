package com.jy.leetcode.minsubserilize;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangyang on 2019/9/9.
 */
class Solution {
    private List<int[]> lists = new ArrayList<>();

    public static void main(String[] args) {
//        LinkedList
//        Collections.binarySearch()
//        int nums[] = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
//        Solution solution = new Solution();
//        int res = solution.lengthOfLIS(nums);

//        int nums[] = new int[]{10, 9, 2, 5, 3, 4};
//        Solution solution = new Solution();
//        int res = solution.lengthOfLIS(nums);
    }

    public int lengthOfLIS(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            putIntLists(nums[i]);
        }
        return getMaxSize();
    }


    private void putIntLists(int ele) {
        if (lists.size() == 0) {
            int[] list = new int[1];
            list[0] = ele;
            lists.add(list);
            return;
        }

        int[] temp = null;
        for (int[] ints : lists) {
            if (ints[ints.length - 1] < ele && (temp == null || temp.length < ints.length)) {
                temp = ints;
            }
        }

        if (temp != null) {
            int[] dest = new int[temp.length + 1];
            System.arraycopy(temp, 0, dest, 0, temp.length);
            dest[temp.length] = ele;
            lists.add(dest);
        } else {
            int[] list = new int[1];
            list[0] = ele;
            lists.add(list);
        }
    }

    public int getMaxSize() {
        int size = 0;
        for (int[] list : lists) {
            if (list.length > size) {
                size = list.length;
            }
        }
        return size;
    }
}
