package com.jy.spring;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiangyang on 2019/8/7.
 */
public class Command {
    private Map<String, String> map = new HashMap<>();

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
