package com.jy.leetcode.mingroup;

import java.util.*;

/**
 * Created by Administrator on 2019/7/20.
 */
public class SolutionOvertime2 {
    public static void main(String[] args) {
        SolutionOvertime2 s = new SolutionOvertime2();
        int[] res = s.smallestSufficientTeam(new String[]{"java", "nodejs", "reactjs"}, all(all("java"), all("nodejs"), all("nodejs", "reactjs")));
    }

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Set<String> reqSkills = toSet(req_skills);
        Map<String, List<Integer>> psMap = map(people, reqSkills);
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
        reqSkills.remove(sk);
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

    private static List all(Object... eles) {
        List list = new ArrayList();
        for (Object e : eles) {
            list.add(e);
        }
        return list;
    }
}
