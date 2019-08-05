package com.jy.leetcode.deckRevealed;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jiangyang on 2019/7/30.
 */
public class Solution2 {
    public static void main(String[] args) {
        int[] input = new int[]{2, 13, 3, 11, 5, 17, 7};
//        int[] input = new int[]{2, 3, 5, 7, 11, 13, 17};
        Solution2 t = new Solution2();
        int[] res= t.deckRevealedIncreasing(input);
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] forwardMap = forward(deck);
        int[] res = new int[deck.length];
        for (int i = 0; i < deck.length; ++i) {
            res[forwardMap[i]] = deck[i];
        }
        return res;
    }

    public int[] forward(int[] deck) {
        int[] res = new int[deck.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < deck.length; ++i) {
            queue.add(i);
        }
        int i = 0;
        while (!queue.isEmpty()) {
            res[i++] = queue.poll();
            if (queue.isEmpty()) {
                break;
            }
            queue.add(queue.poll());
        }
        return res;
    }
}
