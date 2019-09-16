package com.jy.leetcode.minsubserilize;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangyang on 2019/9/9.
 */
public class Solution2 {
    private List<Node> list = new ArrayList<>();

    public static void main(String[] args) {
//        int nums[] = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
//        Solution2 solution = new Solution2();
//        int res = solution.lengthOfLIS(nums);

//        int nums[] = new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6};
//        Solution2 solution = new Solution2();
//        int res = solution.lengthOfLIS(nums);

//        int nums[] = new int[]{2, 15, 3, 7, 8, 6, 18};
//        Solution2 solution = new Solution2();
//        int res = solution.lengthOfLIS(nums);


        int nums[] = new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12};
        Solution2 solution = new Solution2();
        int res = solution.lengthOfLIS(nums);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        list.add(new Node(nums[0]));
        for (int i = 1; i < nums.length; ++i) {
            Node curr = new Node(nums[i]);
            boolean added = false;
            for (Node node : list) {
                if (node.addIntoNearbyLowerNode(curr)) {
                    added = true;
                }
            }
            if (!added) {
                list.add(curr);
            }
        }
        int res = 0;
        for (Node node : list) {
            res = Math.max(res, node.size());
        }
        return res;
    }

    private static class Node implements Comparable<Node> {
        int value;
        List<Node> nextNodes = new ArrayList<>();
//        int deepth = 1;

        public Node(int value) {
            this.value = value;
        }

        public boolean addIntoNearbyLowerNode(Node n) {
            if (n.value < value) {
                return false;
            }
            Node node = getMaxSizeNode(n);
            if (node != null) {
                node.nextNodes.add(n);
//                if (node.nextNodes.size() == 1) {
//                    deepth++;
//                }
                return true;
            }
            if (n.value > value) {
                nextNodes.add(n);
//                if (nextNodes.size() == 1) {
//                    deepth++;
//                }
                return true;
            }
            return false;
        }

        public Node getMaxSizeNode(Node n) {
            int res = 0;
            Node resNode = null;
            for (Node node : nextNodes) {
                if (res < node.size() && node.value < n.value) {
                    res = node.size();
                    resNode = node;
                }
            }
            if (resNode != null) {
                Node temp = resNode.getMaxSizeNode(n);
                if (temp != null) {
                    resNode = temp;
                }
            }
            return resNode;
        }

        public int size() {
            if (nextNodes.size() == 0) {
                return 1;
            }
            int res = 0;
            for (Node node : nextNodes) {
                res = Math.max(res, node.size());
            }
            return res + 1;
        }

        @Override
        public int compareTo(Node node) {
            return this.value < node.value ? -1 : 1;
        }
    }

}
