package com.package1;

import java.util.ArrayList;
import java.util.List;

public class LC228 {
    public List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;

        int start = 0,end = 0;


        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]+1){
                end++;
                continue;
            }
            end = i-1;
            result.add(makeRange(nums,start,end));
            start = end = i;
        }
        result.add(makeRange(nums,start,end));
        return result;
    }

    private String makeRange(int[] nums, int start, int end){
        String range = "";
        if (start < end)
            range = Integer.toString(nums[start]) + "->" + Integer.toString(nums[end]);
        else if (start == end){
            range = Integer.toString(nums[start]);
        }
        return range;
    }


}
