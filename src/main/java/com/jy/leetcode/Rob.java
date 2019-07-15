package com.jy.leetcode;

/**
 * Created by jiangyang on 2019/7/15.
 * 打家劫舍 III
 * https://leetcode-cn.com/problems/house-robber-iii/
 */
public class Rob {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxCurrent = root.val;
        int maxLeftAndRight = 0;

        if (root.left != null) {
            maxLeftAndRight += rob(root.left);
            maxCurrent += rob(root.left.left);
            maxCurrent += rob(root.left.right);
        }
        if (root.right != null) {
            maxLeftAndRight += rob(root.right);
            maxCurrent += rob(root.right.left);
            maxCurrent += rob(root.right.right);
        }

        return Math.max(maxCurrent, maxLeftAndRight);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
