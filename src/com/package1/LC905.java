package com.package1;

public class LC905 {
    public int[] sortArrayByParity(int[] A) {
        int i=0, j= A.length-1;
        while (i < j){
            while (i<A.length && A[i] % 2 == 0) i++;
            while (j>0 && A[j] % 2 != 0) j--;
            if (i==A.length || j == 0 || i>=j) break;
            int t = A[i];
            A[i] = A[j];
            A[j] = t;
        }
        return A;

    }
}
