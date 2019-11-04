package com.jy.leetcode.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by jiangyang on 2019/11/4.
 */
public class LRUCache {
    private LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(capacity,0.75f,true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}
