package com.package1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1200 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i+1] - arr[i] < minDiff){
                minDiff = arr[i+1] - arr[i];
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i+1] - arr[i] == minDiff){
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i+1]);
                result.add(pair);
            }
        }
        return result;
    }

}
