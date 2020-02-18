package com.package1;

import java.util.Arrays;

public class LC026 {
    public int removeDuplicates(int[] nums) {
        int left = 1;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[left-1])
                nums[left++] = nums[right];
        }
        return left;
    }
}
