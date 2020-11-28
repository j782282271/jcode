package com.jy.leetcode.addFriends;

import java.util.Arrays;

/**
 * Created by jiangyang on 2020/1/6.
 * 当满足以下条件时，A 不能给 B（A、B不为同一人）发送好友请求：
 * age[B] <= 0.5 * age[A] + 7
 * age[B] > age[A]
 * age[B] > 100 && age[A] < 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/friends-of-appropriate-ages
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
//        int res = s.numFriendRequests(new int[]{16, 17, 18});
        int res = s.numFriendRequests(new int[]{73, 106, 39, 6, 26, 15, 30, 100, 71, 35, 46, 112, 6, 60, 110});
    }

    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int total = 0;
        for (int i = 0; i < ages.length; ++i) {
            total = total + (getHigherIndex(ages, i, ages[i]) - i);

            int lowerValue = (int) (0.5 * ages[i] + 7) + 1;
            if (lowerValue >= ages[i]) {
                continue;
            }
            int lowerIndex = getLowesterIndex(ages, 0, i, lowerValue);
            total = total + (i - lowerIndex);
        }
        return total;
    }

    private int getHigherIndex(int[] ages, int start, int value) {
        int i = start + 1;
        for (; i < ages.length; ++i) {
            if (value != ages[i]) {
                break;
            }
        }
        return i - 1;
    }

//    public static void main(String[] args) {
//        int res = Arrays.binarySearch(new int[]{5, 5, 5, 6, 16, 17, 18, 20, 21}, 0, 5, 7);
//        int[] ages = new int[]{73, 106, 39, 6, 26, 15, 30, 100, 71, 35, 46, 112, 6, 60, 110};
//        Arrays.sort(ages);
//        res = Arrays.binarySearch(ages, 0, 1, 11);
//    }

    private int getLowesterIndex(int[] ages, int fromIndex, int toIndex, int key) {
        int lowerIndex = Arrays.binarySearch(ages, fromIndex, toIndex, key);
        if (lowerIndex < 0) {
            lowerIndex = -(lowerIndex + 1);
            return lowerIndex;
        }
        int i = lowerIndex - 1;
        for (; i >= 0; --i) {
            if (key != ages[i]) {
                break;
            }
        }
        return i + 1;
    }
}
