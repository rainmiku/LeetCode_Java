package com.package1;

public class LC377 {
    public int combinationSum4(int[] nums, int target) {
        int[] sums = new int[target+1];
        sums[0] = 1;
        for (int i = 1; i < sums.length; i++) {
            for (int num: nums)
                if (num <= i)
                    sums[i] += sums[i-num];
        }
        return sums[target];
    }
}
