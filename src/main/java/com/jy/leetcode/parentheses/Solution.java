package com.jy.leetcode.parentheses;

import java.util.Stack;

/**
 * Created by jiangyang on 2019/12/6.
 */
class Solution {
    public static void main(String[] args) {
        String input = "))((";
        Solution s = new Solution();
        String res = s.minRemoveToMakeValid(input);
    }

    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (Integer i = 0; i < chars.length; ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    chars[i] = '\0';
                    continue;
                }
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            chars[stack.pop()] = '\0';
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] != '\0') {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
