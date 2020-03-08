package com.package1.Contest179;

import java.util.HashMap;

public class LC5355 {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        HashMap<Integer,Integer> childCount = new HashMap<>();
        HashMap<Integer,Integer> father = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int child = Math.max(edges[i][0], edges[i][1]);
            int root = Math.min(edges[i][0], edges[i][1]);
            childCount.put(root, childCount.getOrDefault(root,0)+1);
            father.put(child, root);
        }

        int c = target;
        int s = 1;
        int level = 0;
        while (father.containsKey(c)){
            int root = father.get(c);
            s *= childCount.get(root);
            c = root;
            level++;
        }
        if (t < level || t > level && childCount.containsKey(target) ) return 0;
        return 1.0/s;
    }
}
