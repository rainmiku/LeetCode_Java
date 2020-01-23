package com.package1;


public class LC1020 {

    public int numEnclaves(int[][] A) {
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            dfs(A,i,0);
            dfs(A,i,A[0].length-1);
        }

        for (int j = 0; j < A[0].length ; j++) {
            dfs(A,0,j);
            dfs(A,A.length-1,j);
        }

        for (int i = 1; i < A.length-1; i++) {
            for (int j = 1; j < A[0].length-1; j++) {
                if (A[i][j] == 1)
                    sum++;
            }
        }

        return sum;

    }
    private void dfs (int[][]A, int x, int y){
       if (x < 0 || y < 0 || x >= A.length || y >= A[0].length)
           return;
       if (A[x][y] == 0) return;

       A[x][y] = 0;
       dfs(A,x+1,y);
       dfs(A,x-1,y);
       dfs(A,x,y+1);
       dfs(A,x,y-1);

    }

}
