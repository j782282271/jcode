package com.jy.leetcode.lru;

import java.util.HashMap;

/**
 * Created by jiangyang on 2019/11/4.
 */
public class LRUCache {
    private HashMap<Integer, Node> map;
    private Node firstNode = new Node(-1, -1, null);
    private Node lastNode = firstNode;
    private int size;

    public LRUCache(int capacity) {
        size = capacity;
        map = new HashMap<>(size);
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        move2Last(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key) && map.size() >= size) {
            Node secd = firstNode.next;
            map.remove(secd.key);
            firstNode.next = secd.next;
            if (secd.next != null) {
                secd.next.pre = firstNode;
            }
        }
        Node curr = map.get(key);
        if (curr == null) {
            curr = new Node(key, value, lastNode);
            appendLast(curr);
            map.put(key, curr);
        } else {
            move2Last(curr);
            curr.value = value;
        }
    }

    private class Node {
        Integer key;
        Integer value;
        Node next;
        Node pre;

        public Node(Integer k, Integer v, Node p) {
            key = k;
            value = v;
            pre = p;
        }
    }

    private void move2Last(Node node) {
        if (node == lastNode) {
            return;
        }
        node.pre.next = node.next;
        if (node.next != null) {
            node.next.pre = node.pre;
        }
        appendLast(node);
    }

    private void appendLast(Node curr) {
        lastNode.next = curr;
        curr.pre = lastNode;
        lastNode = curr;
    }
}
