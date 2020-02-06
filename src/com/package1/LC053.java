package com.package1;

public class LC053 {
    public int maxSubArray(int[] nums) {

        int[] f = new int[nums.length];
        int max = nums[0];

        f[0] = nums[0];
        for (int i = 1; i < f.length; i++) {
            f[i] = Math.max(nums[i] + f[i - 1], nums[i]);
            max = Math.max(f[i],max);
        }
       return max;
    }
}
