package com.package1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        if (graph.length == 0) return result;
        List<Integer> path = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();

        dfs(graph,0,path,visited,result);

        return result;
    }

    private void dfs(int[][] graph, int node, List<Integer> path, HashSet<Integer> visited, List<List<Integer>> result){

        visited.add(node);
        path.add(node);

        if (node == graph.length-1) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int next:graph[node]) {
            if (visited.contains(next))
                continue;
            dfs(graph,next,path,visited,result);
            visited.remove(next);
            path.remove(path.size()-1);
        }
    }

}
