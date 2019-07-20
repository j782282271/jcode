package com.jy.leetcode.mingroup;

/**
 * Created by Administrator on 2019/7/20.
 */

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2019/7/20.
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.smallestSufficientTeam(new String[]{"cdkpfwkhlfbps", "hnvepiymrmb", "cqrdrqty", "pxivftxovnpf", "uefdllzzmvpaicyl", "idsyvyl"}, createP1());
    }

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        List<Integer> listRes = new ArrayList<>();
        minPeople(toList(req_skills), people, 0, listRes);
        int[] res = new int[listRes.size()];
        for (int i = 0; i < res.length; ++i) {
            res[i] = listRes.get(i);
        }
        return res;
    }

    private void minPeople(List<String> reqSkills, List<List<String>> people, int start, List<Integer> res) {
        if (start >= people.size() || reqSkills.size() == 0) {
            return;
        }

        for (int i = start; i < people.size(); ++i) {
            if (people.get(i).size() == 0) {
                continue;
            }
            //不使用当前person计算最小团队
            minPeople(reqSkills, people, start + 1, res);
            if (reqSkills.size() == 0) {
                break;
            }else if(reqSkills.removeAll(people.get(i))){
                res.add(i);
            }
        }
    }

    private void minSize(List<Integer> l1, List<Integer> l2) {
        if (l1.size() <= l2.size()) {
            return;
        } else {
            l1.clear();
            l1.addAll(l2);
        }
    }

    private List<String> toList(String[] req_sksills) {
        List<String> res = new ArrayList<>(req_sksills.length);
        for (String sk : req_sksills) {
            res.add(sk);
        }
        return res;
    }

    private static List<List<String>> createP2() {
        List<String> e1 = new ArrayList<>();
        addAll(e1);

        List<String> e2 = new ArrayList<>();
        addAll(e2, "hnvepiymrmb");

        List<String> e3 = new ArrayList<>();
        addAll(e3, "uefdllzzmvpaicyl");

        List<String> e4 = new ArrayList<>();
        addAll(e4);

        List<String> e5 = new ArrayList<>();
        addAll(e5, "hnvepiymrmb", "cqrdrqty");

        List<String> e6 = new ArrayList<>();
        addAll(e6, "pxivftxovnpf");

        List<String> e7 = new ArrayList<>();
        addAll(e7, "hnvepiymrmb", "pxivftxovnpf");

        List<String> e8 = new ArrayList<>();
        addAll(e8, "hnvepiymrmb");

        List<String> e9 = new ArrayList<>();
        addAll(e9, "cdkpfwkhlfbps");

        List<String> e10 = new ArrayList<>();
        addAll(e10, "idsyvyl");

        List<String> e11 = new ArrayList<>();
        addAll(e11);

        List<String> e12 = new ArrayList<>();
        addAll(e12, "cdkpfwkhlfbps", "uefdllzzmvpaicyl");

        List<String> e13 = new ArrayList<>();
        addAll(e13, "cdkpfwkhlfbps", "uefdllzzmvpaicyl");

        List<String> e14 = new ArrayList<>();
        addAll(e14, "pxivftxovnpf", "uefdllzzmvpaicyl");

        List<String> e15 = new ArrayList<>();
        addAll(e15);

        List<String> e16 = new ArrayList<>();
        addAll(e16, "cqrdrqty");

        List<String> e17 = new ArrayList<>();
        addAll(e17);

        List<String> e18 = new ArrayList<>();
        addAll(e18, "cqrdrqty", "pxivftxovnpf", "idsyvyl");

        List<String> e19 = new ArrayList<>();
        addAll(e19, "hnvepiymrmb", "idsyvyl");

        List<String> e20 = new ArrayList<>();
        addAll(e20);

        List<List<String>> people = new ArrayList<>();
        addAll(people, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16, e17, e18, e19, e20);
        return people;
    }

    private static List<List<String>> createP1() {
        List<String> e1 = new ArrayList<>();
        addAll(e1, "algorithms", "math", "java");

        List<String> e2 = new ArrayList<>();
        addAll(e2, "algorithms", "math", "reactjs");

        List<String> e3 = new ArrayList<>();
        addAll(e3, "java", "csharp", "aws");

        List<String> e4 = new ArrayList<>();
        addAll(e4, "reactjs", "csharp");

        List<String> e5 = new ArrayList<>();
        addAll(e5, "csharp", "math");

        List<String> e6 = new ArrayList<>();
        addAll(e6, "aws", "java");

        List<List<String>> people = new ArrayList<>();
        addAll(people, e1, e2, e3, e4, e5, e6);
        return people;
    }

    private static void addAll(List list, Object... eles) {
        for (Object e : eles) {
            list.add(e);
        }
    }
}
