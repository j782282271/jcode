package com.jy.leetcode.timemap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by jiangyang on 2019/8/5.
 * https://leetcode-cn.com/problems/time-based-key-value-store/
 * 45个用例，第44个超时
 */
class TimeMap0 {

    private Map<String, TreeMap<Integer, String>> map = new HashMap<>();

    public TimeMap0() {

    }

    public void set(String key, String value, int timestamp) {
        TreeMap treeMap = map.computeIfAbsent(key, (k) -> new TreeMap());
        treeMap.put(timestamp, value);
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

        TimeMap0 timeMap0 = new TimeMap0();
        timeMap0.set("love", "high", 10);
        timeMap0.set("love", "low", 20);
        String val1 = timeMap0.get("love", 5);
        String val2 = timeMap0.get("love", 10);
    }
}
