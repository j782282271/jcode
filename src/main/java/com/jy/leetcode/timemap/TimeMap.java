package com.jy.leetcode.timemap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by jiangyang on 2019/8/5.
 * https://leetcode-cn.com/problems/time-based-key-value-store/
 */
class TimeMap {

    /**
     * key-timestamp-value
     */
    private Map<String, TreeMap<Integer, String>> map = new HashMap<>();
    /**
     * key-lastValue
     */
    private Map<String, String> lastValue = new HashMap<>();

    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        String lastV = lastValue.get(key);
        if (lastV != null && lastV.equals(value)) {
            return;
        }
        map.computeIfAbsent(key, (k) -> new TreeMap<>()).put(timestamp, value);
        lastValue.put(key, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key);
        if (treeMap == null) {
            return "";
        }
        Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
        if (entry == null) {
            return "";
        }
        return entry.getValue();
    }

    public static void main(String[] args) {
//        ["TimeMap", "set", "set", "get", "get", "get", "get", "get"]
//[[],["love", "high", 10],["love", "low", 20],["love", 5],["love", 10],["love", 15],["love", 20],["love", 25]]
//        [null, null, null, "", "", "", "low", "low"]
//        [null, null, null, "", "high", "high", "low", "low"]

        TimeMap timeMap = new TimeMap();
        timeMap.set("love", "high", 10);
        timeMap.set("love", "low", 20);
        timeMap.set("love", "high", 30);
        String val1 = timeMap.get("love", 5);
        String val2 = timeMap.get("love", 10);
        String val3 = timeMap.get("love", 31);
    }
}
