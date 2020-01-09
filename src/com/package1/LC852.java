package com.package1;

public class LC852 {
    public int peakIndexInMountainArray(int[] A) {
        int left = 0;
        int right = A.length-1;

        while (left <= right){
            int middle = (left + right) / 2;
            if (A[middle] > A[middle-1] && A[middle] > A[middle+1])
                return middle;
            if (A[middle] < A[middle-1]){
                right = middle-1;
                continue;
            }
            if (A[middle] < A[middle+1]){
                left = middle+1;
            }
        }
        return -1;
    }
}
