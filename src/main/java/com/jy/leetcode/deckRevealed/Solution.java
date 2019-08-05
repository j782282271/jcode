package com.jy.leetcode.deckRevealed;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by jiangyang on 2019/7/29.
 */
class Solution {
    public static void main(String[] args) {
        int[] input = new int[]{17, 13, 11, 2, 3, 5, 7};
        Solution s = new Solution();
        int[] res = s.deckRevealedIncreasing(input);
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        if (deck.length == 0) {
            return deck;
        }
        Arrays.sort(deck);
        LinkedList<Integer> list = new LinkedList<>();
        list.add(deck[deck.length - 1]);
        for (int i = deck.length - 2; i >= 0; --i) {
            list.addFirst(list.removeLast());
            list.addFirst(deck[i]);
        }
        for (int i = 0; i < deck.length; ++i) {
            deck[i] = list.removeFirst();
        }
        return deck;
    }
}
