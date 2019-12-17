package com.package1;

import java.util.HashSet;
import java.util.Set;

public class LC268 {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i))
                return i;
        }
        return -1;
    }

}
