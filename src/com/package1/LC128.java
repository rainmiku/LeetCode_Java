package com.package1;

import java.util.HashSet;


public class LC128 {
    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        HashSet<Integer> hashSet = new HashSet<>();
        for (int num:nums) {
            hashSet.add(num);
        }

        int max = 1;
        for (int num:nums) {
            if (hashSet.contains(num-1))
                continue;
            int length = 1;
            int k = num;
            while (hashSet.contains(k+1)){
                length++;
                k++;
            }
            max = Math.max(length,max);
        }

        return max;
    }


}
