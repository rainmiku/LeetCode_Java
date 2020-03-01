package com.package1.Contest178;

//dp? : f[i][j] = min(f[i-gx][j-gy], min(f[i-dx][j-dy]+1)
// 图论： 相邻格子的cost初始位1，如果grid里有指向，则变为0，最后最短路径

import java.util.*;

public class LC5347_Graph {

    class Point {
        int x, y;
        int dir;

        Point(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    public int minCost(int[][] grid) {
        HashMap<Integer, Point> map = new HashMap<>();

        int[][] graph = makeGraph(grid, map);
        HashSet<Integer> set = new HashSet<>();
        int n = graph.length;
        int[] distance = new int[n];

        set.add(0);
        distance[0] = 0;


        for (int i = 1; i < n; i++) {
            int dmin = Integer.MAX_VALUE;
            int k = -1;
            for (int j = 0; j < n; j++) {
                if (!set.contains(j) && graph[0][j] < dmin) {
                    dmin = graph[0][j];
                    k = j;
                }
            }

            set.add(k);
            distance[k] = dmin;

            for (int j = 0; j < n; j++) {
                if (!set.contains(j) && graph[0][k] + graph[k][j] < graph[0][j])
                    graph[0][j] = graph[0][k] + graph[k][j];
            }
        }

        return distance[n - 1];
    }


    private int[][] makeGraph(int[][] grid, HashMap<Integer, Point> map) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                map.put(count++, new Point(i, j, grid[i][j]-1));
            }
        }

        int[][] graph = new int[count][count];
        int[][] next = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if (i == j) continue;
                graph[i][j] = count;
                if (isNeighbor(map.get(i), map.get(j))) {
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if (i == j) continue;
                if (canReach(map.get(i), map.get(j), next)) {
                    graph[i][j] = 0;
                }
            }
        }
        return graph;
    }


    private boolean isNeighbor(Point a, Point b) {
        if (Math.abs(a.x - b.x) == 1 && a.y == b.y) return true;
        if (a.x == b.x && Math.abs(a.y - b.y) == 1) return true;
        return false;
    }

    private boolean canReach(Point a, Point b, int[][] next) {
        return (a.x + next[a.dir][0] == b.x && a.y + next[a.dir][1] == b.y);
    }


}
