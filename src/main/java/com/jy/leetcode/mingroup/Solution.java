package com.jy.leetcode.mingroup;

import java.util.*;

/**
 * Created by Administrator on 2019/7/20.
 */
public class Solution {

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Set<String> reqSkills = toSet(req_skills);
        preProcess(people);
        Map<String, List<Integer>> psMap = map(people, reqSkills);
        //优化速度
        reqSkills = toSet(req_skills, psMap);
        Set<Integer> resSet = smallestSufficientTeam(reqSkills, people, psMap);

        int[] res = new int[resSet.size()];
        int i = 0;
        for (Integer p : resSet) {
            res[i] = p;
            ++i;
        }
        return res;
    }

    private Set<Integer> smallestSufficientTeam(Set<String> reqSkills, List<List<String>> people, Map<String, List<Integer>> psMap) {
        Set<Integer> res = null;
        if (reqSkills.size() == 0) {
            return res;
        }
        String sk = reqSkills.iterator().next();
        List<Integer> ps = psMap.get(sk);
        for (Integer p : ps) {
            Set<String> reqSkillsTemp = new HashSet<>(reqSkills);
            reqSkillsTemp.removeAll(people.get(p));
            Set<Integer> resTemp = new HashSet<>();
            resTemp.add(p);
            if (reqSkillsTemp.size() != 0) {
                Set<Integer> resTemp1 = smallestSufficientTeam(reqSkillsTemp, people, psMap);
                if (resTemp1 != null) {
                    resTemp.addAll(resTemp1);
                }
            }
            if (res == null || resTemp.size() < res.size()) {
                res = resTemp;
            }
        }
        return res;
    }

    private static Map<String, List<Integer>> map(List<List<String>> people, Set<String> reqSkills) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < people.size(); ++i) {
            for (String sk : people.get(i)) {
                if (!reqSkills.contains(sk)) {
                    continue;
                }
                map.putIfAbsent(sk, new ArrayList<>());
                map.get(sk).add(i);
            }
        }
        return map;
    }

    private Set<String> toSet(String[] req_sksills) {
        Set<String> res = new HashSet<>(req_sksills.length);
        for (String sk : req_sksills) {
            res.add(sk);
        }
        return res;
    }

    private Set<String> toSet(String[] req_sksills, Map<String, List<Integer>> psMap) {
        TreeSet<String> res = new TreeSet<>((o1, o2) -> psMap.get(o1).size() <= psMap.get(o1).size() ? 1 : -1);
        for (String sk : req_sksills) {
            res.add(sk);
        }
        return res;
    }

    private void preProcess(List<List<String>> people) {
        for (int i = 0; i < people.size(); ++i) {
            for (int j = 0; j < people.size(); ++j) {
                if (i != j && people.get(j).containsAll(people.get(i))) {
                    people.set(i, new ArrayList<>());
                    break;
                }
            }
        }
    }
}
