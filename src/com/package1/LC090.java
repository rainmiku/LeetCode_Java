package com.package1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        Arrays.sort(nums);
        int start, end = 0;
        for (int i = 0; i < nums.length; i++) {
            start = 0;
            if (i > 0 && nums[i] == nums[i-1])
                start = end;
            end = subsets.size();
            for (int j = start; j <end ; j++) {
                List<Integer> set = new ArrayList<>(subsets.get(j));
                set.add(nums[i]);
                subsets.add(set);
            }
        }
        return subsets;
    }
}
