package com.jy.leetcode.maxsubserilize;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangyang on 2019/9/9.
 */
public class SolutionTimeOut {
    private List<List<Integer>> lists = new ArrayList<>();

    public int lengthOfLIS(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            putIntLists(nums[i]);
        }
        return getMaxSize();
    }


    private void putIntLists(int ele) {
        if (lists.size() == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(ele);
            lists.add(list);
            return;
        }

        boolean added = false;
        List<List<Integer>> temp = new ArrayList<>();
        for (List<Integer> list : lists) {
            if (list.get(list.size() - 1) < ele) {
                temp.add(list);
                added = true;
            }
        }

        for (List<Integer> list : temp) {
            List<Integer> dest = new ArrayList<>(list);
            dest.add(ele);
            lists.add(dest);
        }


        if (added == false) {
            List<Integer> list = new ArrayList<>();
            list.add(ele);
            lists.add(list);
        }
    }

    public int getMaxSize() {
        int size = 0;
        for (List<Integer> list : lists) {
            if (list.size() > size) {
                size = list.size();
            }
        }
        return size;
    }
}

