package com.package1;

public class LC064 {
    private int max = 0;
    public int minPathSum(int[][] grid) {
        minPathSum(grid,0,0,grid[0][0]);
        return max;
    }

    private void minPathSum(int[][] grid, int i, int j,int sum){
        if (i==grid.length-1 && j==grid[0].length-1)
        {
            if (sum > max)
                max = sum;
            return;
        }

        if (i == grid.length || j == grid[0].length)
            return;

        minPathSum(grid,i+1,j,sum+grid[i+1][j]);
        minPathSum(grid,i,j+1,sum+grid[i][j+1]);
    }
}
