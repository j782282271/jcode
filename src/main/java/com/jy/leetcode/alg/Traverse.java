package com.jy.leetcode.alg;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by jiangyang on 2019/7/16.
 */
public class Traverse {
    /**
     * *********1
     * *****2      3
     * ***4  5   6  7
     */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        Traverse traverse = new Traverse();

        traverse.bfs(treeNode);
        traverse.bfs2(treeNode);
        traverse.bfs3(treeNode);
        traverse.dfs(treeNode);
    }

    /**
     * 广度优先搜索：用queue
     */
    public void bfs(TreeNode treeNode) {
        System.out.print("bfs:");
        Queue<TreeNode> queue = new ConcurrentLinkedQueue();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            System.out.print(curr.val + " ");
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
        System.out.println();
    }

    /**
     * 广度优先搜索：用queue
     */
    public void bfs2(TreeNode treeNode) {
        System.out.print("bfs2:");
        Queue<TreeNode> queue = new ConcurrentLinkedQueue();
        System.out.print(treeNode.val + " ");
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.left != null) {
                System.out.print(curr.left.val + " ");
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                System.out.print(curr.right.val + " ");
                queue.offer(curr.right);
            }
        }
        System.out.println();
    }

    /**
     * 广度优先搜索：用stack,严格的说算不上广度优先，也算不上是深度优先
     */
    public void bfs3(TreeNode treeNode) {
        System.out.print("bfs3:");
        Stack<TreeNode> stack = new Stack();
        System.out.print(treeNode.val + " ");
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            treeNode = stack.pop();
            if (treeNode.left != null) {
                System.out.print(treeNode.left.val + " ");
                stack.push(treeNode.left);
            }
            if (treeNode.right != null) {
                System.out.print(treeNode.right.val + " ");
                stack.push(treeNode.right);
            }
        }
        System.out.println();
    }

    /**
     * 深度优先搜索：用stack
     */
    public void dfs(TreeNode treeNode) {
        System.out.print("dfs:");
        Stack<TreeNode> stack = new Stack();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            treeNode = stack.pop();
            System.out.print(treeNode.val + " ");
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
        }
        System.out.println();
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
