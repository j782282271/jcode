package com.jy.leetcode.courseSchedule;

import java.util.Arrays;

/**
 * Created by jiangyang on 2019/10/30.
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        int[] ruDu = new int[numCourses];
        int[][] chuDuArray = chuDuArray(numCourses, sort(prerequisites));

        for (int i = 0; i < prerequisites.length; ++i) {
            ruDu[prerequisites[i][1]]++;
        }

        boolean isChanged;
        int ruDu0Num;
        while (true) {
            isChanged = false;
            ruDu0Num = 0;
            for (int i = 0; i < numCourses; ++i) {
                if (ruDu[i] == 0) {
                    ruDu0Num++;
                    if (null != chuDuArray[i]) {
                        for (int j : chuDuArray[i]) {
                            ruDu[j]--;
                            isChanged = true;
                        }
                        chuDuArray[i] = null;
                    }
                }
            }
            if (ruDu0Num == numCourses) {
                return true;
            }
            if (!isChanged) {
                return false;
            }
        }
    }

    private int[][] sort(int[][] prerequisites) {
        Arrays.sort(prerequisites, (int[] a, int[] b) -> a[0] < b[0] ? -1 : 1);
        return prerequisites;
    }

    private int[][] chuDuArray(int numCourses, int[][] prerequisites) {
        int[][] preRequisites = new int[numCourses][];
        int pre = -1;
        int size = 0;
        int lastPos = 0;
        for (int i = 0; i < prerequisites.length; ++i) {
            if (pre != prerequisites[i][0] && size > 0) {
                preRequisites[pre] = new int[size];
                for (int j = i - size; j < i; ++j) {
                    preRequisites[pre][j - i + size] = prerequisites[j][1];
                }
                size = 0;
                lastPos = i;
            }
            pre = prerequisites[i][0];
            size++;
        }

        preRequisites[pre] = new int[prerequisites.length - lastPos];
        for (int i = lastPos; i < prerequisites.length; ++i) {
            preRequisites[pre][i - lastPos] = prerequisites[i][1];
        }
        return preRequisites;
    }
}