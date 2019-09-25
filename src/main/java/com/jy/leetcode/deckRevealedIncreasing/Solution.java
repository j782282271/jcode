package com.jy.leetcode.deckRevealedIncreasing;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Administrator on 2019/7/29.
 * https://leetcode-cn.com/problems/reveal-cards-in-increasing-order/
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] res = s.deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7});
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        LinkedList<Integer> stack = new LinkedList<>();
        int i = 0;
        while (i < deck.length) {
            if (stack.size() != 0) {
                Integer last = stack.pollLast();
                stack.addFirst(last);
            }
            stack.addFirst(deck[deck.length - 1 - i]);
            i++;
        }
        for (int i1 = 0; i1 < stack.size(); i1++) {
            deck[i1] = stack.get(i1);
        }
        return deck;
    }
}