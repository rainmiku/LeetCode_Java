package com.package1.Contest178;

import java.util.Arrays;

public class LC5344 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] copy = new int[nums.length];
        int[] result = new int[nums.length];

        copy = nums.clone();
        Arrays.sort(copy);
        for (int i = 0; i <nums.length ; i++) {
            int sum = 0;
            for (int k = 0; k < copy.length; k++) {
                if (copy[k] < nums[i]) sum++;
                else break;
            }
            result[i] = sum;
        }
        return result;
    }
}
