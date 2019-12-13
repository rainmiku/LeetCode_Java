package com.package1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class LC832 {
    public int[][] flipAndInvertImage(int[][] A) {

        if (A == null) return null;
        A = flipImage(A);
        System.out.println(Arrays.deepToString(A));
        A = invertImage(A);

        return A;
        

    }
    
    private int[][] flipImage(int[][] A){
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length/2; j++) {
                int t = A[i][j];
                A[i][j] = A[i][A[0].length-j-1];
                A[i][A[0].length-j-1] = t;
            }
        }
        return A;
    }
    
    private int[][] invertImage(int[][] A){
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j]==0)
                    A[i][j] = 1;
                else
                    A[i][j] = 0;
            } 
        }
        return A;
    }
}
