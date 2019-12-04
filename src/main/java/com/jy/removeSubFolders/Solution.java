package com.jy.removeSubFolders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jiangyang on 2019/11/25.
 */
class Solution {
    private static final Node HAS_PARENT = new Node();
    private static final Node HAS_SON = new Node();
    private static final Node HAS_BRO = new Node();

    Map<String, Node> roots = new HashMap<>();

    public List<String> removeSubfolders(String[] folder) {
        for (String f : folder) {
            String[] path = f.split("/");
            Node node = roots.get(path[1]);
            if (node == null) {
                roots.put(path[1], new Node(1, path));
                continue;
            }
            Node putRes = node.searchAndPutIfNeed(2, path);
            if (putRes == HAS_SON) {
                roots.put(path[1], new Node(1, path));
            }
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Node> entry : roots.entrySet()) {
            res.addAll(entry.getValue().printPath());
        }
        return res;
    }


    private static class Node {
        String path;
        Map<String, Node> subPath;

        Node() {

        }

        Node(int start, String[] path) {
            this.path = path[start];
            if (path.length - start <= 1) {
                return;
            }
            subPath = new HashMap<>();
            subPath.put(path[++start], new Node(start, path));
        }

        public Node searchAndPutIfNeed(int start, String[] path) {
            if (start >= path.length) {
                this.subPath = null;
            }
            if (subPath == null) {
                return HAS_PARENT;
            }
            Node node = subPath.get(path[start]);
            if (node == null) {
                subPath.put(path[start], new Node(start, path));
                return HAS_BRO;
            }
            return node.searchAndPutIfNeed(++start, path);
        }

        public List<String> printPath() {
            List<String> res = new ArrayList<>();
            printPath("", res);
            return res;
        }

        public void printPath(String prefix, List<String> res) {
            prefix = prefix + "/" + path;
            if (subPath == null) {
                res.add(prefix);
                return;
            }
            for (Map.Entry<String, Node> entry : subPath.entrySet()) {
                entry.getValue().printPath(prefix, res);
            }
        }
    }
}
