package com.jy.leetcode.minsubserilize;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangyang on 2019/9/9.
 */
class Solution {
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

        List<Integer> temp = null;
        for (List<Integer> list : lists) {
            if (list.get(list.size() - 1) < ele && (temp == null || temp.size() < list.size())) {
                temp = list;
            }
        }

        if (temp != null) {
            List<Integer> dest = new ArrayList<>(temp);
            dest.add(ele);
            lists.add(dest);
        } else {
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
