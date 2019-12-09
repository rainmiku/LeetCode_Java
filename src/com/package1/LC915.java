package com.package1;


public class LC915 {
    public int partitionDisjoint(int[] A) {

        int[] leftMax = new int[A.length];
        int[] rightMin = new int[A.length];

        int max = A[0];
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= max)
                max = A[i];

            leftMax[i] = max;

        }

        int min = A[A.length-1];
        for (int i = A.length-1; i >= 0; i--) {
            if (A[i] <= min)
                min = A[i];

            rightMin[i] = min;

        }


        for (int i = 0; i < A.length-1; i++) {
            if (leftMax[i] <= rightMin[i+1])
                return i+1;
        }
        return 0;
    }
}
