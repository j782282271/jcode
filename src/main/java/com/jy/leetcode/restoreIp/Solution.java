package com.jy.leetcode.restoreIp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangyang on 2019/12/4.
 */
class Solution {
    private String input;

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        this.input = s;
        restoreIpInner(0, 0, new StringBuilder(), res);
        return res;
    }

    public void restoreIpInner(int start, int part, StringBuilder sb, List<String> res) {
        if (part == 3) {
            String end = input.substring(start, input.length());
            if (isIpPart(end)) {
                sb.append(end);
                res.add(sb.toString());
                sb.setLength(sb.length() - end.length());
            }
            return;
        }
        for (int i = 1; i < 4; ++i) {
            if (start >= input.length() || start + i >= input.length()) {
                break;
            }
            String prefix = input.substring(start, start + i);
            if (isIpPart(prefix)) {
                restoreIpInner(start + i, part + 1, sb.append(prefix + "."), res);
                sb.setLength(sb.length() - 1 - i);
            }
        }
    }

    private static boolean isIpPart(String ipPart) {
        if (ipPart.length() == 0 || ipPart.length() > 3) {
            return false;
        }
        if (ipPart.startsWith("0") && ipPart.length() > 1) {
            return false;
        }
        if (ipPart.length() == 1 || ipPart.length() == 2) {
            return true;
        }
        if (ipPart.length() == 3 && ipPart.compareTo("255") <= 0) {
            return true;
        }
        return false;
    }
}
