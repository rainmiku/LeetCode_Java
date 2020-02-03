package com.package1;

import java.util.ArrayList;
import java.util.List;


public class LC658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int closeIdx = binarySearch(arr,x);

        int left = closeIdx, right = closeIdx;
        
        while (right-left < k-1){
            if (left <= 0){
                right++;
                continue;
            }
            if (right >= arr.length-1){
                left--;
                continue;
            }
            if (Math.abs(arr[left-1]-x) <= Math.abs(arr[right+1]-x)){
                left--;
            }
            else {
                right++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right ; i++) {
            result.add(arr[i]);
        }

        return result;

    }

    private int binarySearch(int[] arr, int x){
        int left = 0;
        int right = arr.length-1;

        while (left < right){
            int middle = (left+right)/2;
            if (arr[middle] == x) return middle;
            if (arr[middle] > x)
                right = middle-1;
            else left = middle+1;

        }
        return left;
    }
}
