package com.package1.Contest178;

public class LC5347 {
    int cost = 0;
    public int minCost(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] dir = new int[][]{{0,1}, {0,-1},{1,0}, {-1,0}};

        return 0;


    }

    private void findPath(int[][] grid, int cost, boolean[][] visited, int[][] dir, int x, int y){
        int m = grid.length;
        int n = grid[0].length;
        if (x == m || y == n || x < 0 || y < n) return;
        findPath(grid,cost,visited,dir, x+dir[grid[x][y]][0],y+dir[grid[x][y]][1]);

    }


}
