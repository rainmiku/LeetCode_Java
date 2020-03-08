package com.package1.Contest179;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC5354 {
    int maxTime = 0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            if (!map.containsKey(manager[i])){
                map.put(manager[i], new ArrayList<>());
            }
            map.get(manager[i]).add(i);
        }
        dfs(headID,map,informTime,0);
        return maxTime;
    }
    private void dfs(int root, HashMap<Integer, List<Integer>> map, int[] informTime, int time){
        if (informTime[root] == 0){
            maxTime = Math.max(maxTime,time);
            return;
        }
        for (int child:map.get(root)) {
            dfs(child,map,informTime,time+informTime[root]);
        }
    }

}
