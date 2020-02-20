package com.package1;

import java.util.ArrayList;
import java.util.Arrays;

public class LC056 {
    public int[][] merge(int[][] intervals) {

        if (intervals.length==0) return new int[][]{};

        ArrayList<int[]> mergedList = new ArrayList<>();

        Arrays.sort(intervals,(a, b)->(a[0]-b[0]));

        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i <intervals.length ; i++) {
            int[] interval = intervals[i];
            if (interval[0] > end){
                mergedList.add(new int[]{start,end});
                start = interval[0];
                end = interval[1];
                continue;
            }
            end = Math.max(interval[1],end);
        }
        mergedList.add(new int[]{start,end});

        return mergedList.toArray(new int[mergedList.size()][]);
    }
}
