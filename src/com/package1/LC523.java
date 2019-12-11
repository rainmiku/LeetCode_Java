package com.package1;

public class LC523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (k == 0){
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 0 && nums[i-1] == 0)
                    return true;
            }
            return false;
        }
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i-1]+ nums[i];
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int subsum;
                if (i == 0)
                    subsum = sums[j];
                else
                    subsum = sums[j] - sums[i-1];
                if (subsum % k == 0)
                    return true;
            }
        }
        return false;
    }
}
