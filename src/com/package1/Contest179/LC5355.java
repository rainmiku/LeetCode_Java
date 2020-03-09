package com.package1.Contest179;

import java.util.HashMap;

public class LC5355 {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        HashMap<Integer,Integer> childCount = new HashMap<>();  //map to count count of children
        HashMap<Integer,Integer> father = new HashMap<>();   //map to record the nodes's father
        for (int i = 0; i < edges.length; i++) {
            //always let the smaller be the father
            int child = Math.max(edges[i][0], edges[i][1]);
            int root = Math.min(edges[i][0], edges[i][1]);
            childCount.put(root, childCount.getOrDefault(root,0)+1);
            father.put(child, root);
        }

        int c = target;
        int s = 1;
        int level = 0;
        while (father.containsKey(c)){  //go back each level from target and calculate the rate
            int root = father.get(c);
            s *= childCount.get(root);
            c = root;
            level++;   //record how many level/second should use
        }
        if (t < level || t > level && childCount.containsKey(target) ) return 0; //if the time is not enough or too much then return 0
        return 1.0/s;
    }
}
