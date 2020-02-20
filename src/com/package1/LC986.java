package com.package1;

import java.util.ArrayList;

public class LC986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A.length == 0 || B.length == 0 ) return new int[][]{};
        ArrayList<int[]> intersected = new ArrayList<>();
        int i1=0, i2=0;

        while (i2 < B.length){
            int[] target = B[i2];
            while (i1 < A.length && A[i1][1] < target[0])
                i1++;
            while (i1 < A.length && A[i1][0] <= target[1]){
                int start = Math.max(A[i1][0],target[0]);
                int end = Math.min(A[i1][1],target[1]);
                intersected.add(new int[]{start,end});
                i1++;
            }
            if (i1 > 0 ) i1--;
            i2++;
        }
        return intersected.toArray(new int[intersected.size()][]);
    }
}
