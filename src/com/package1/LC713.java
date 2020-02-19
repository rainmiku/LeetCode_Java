package com.package1;

public class LC713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, count = 0;
        long product = 1;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k && left < right)
                product /= nums[left++];
            if (product < k)
                count += right - left+1;
        }
        return count;
    }
}
