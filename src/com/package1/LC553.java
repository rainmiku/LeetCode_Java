package com.package1;

public class LC553 {
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) return String.valueOf(nums[0]);
        if (nums.length == 2) return String.valueOf(nums[0])+"/" + String.valueOf(nums[1]);

        String result = String.valueOf(nums[0]) + "/(";
        for (int i = 1; i < nums.length-1; i++) {
            result += String.valueOf(nums[i]) + "/";
        }
        result += String.valueOf(nums[nums.length-1]) + ")";
        return result;
    }
}
