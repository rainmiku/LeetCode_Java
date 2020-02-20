package com.package1;

public class LC581 {
    public int findUnsortedSubarray(int[] nums) {
        int left, right;

        for(left = 0; left < nums.length-1;left++)
            if (nums[left] > nums[left+1])
                break;

        for(right = nums.length-1; right > 0; right--)
            if (nums[right] < nums[right-1])
                break;

        if (left >= right) return 0;

        int max = nums[left], min = nums[left];

        for (int i = left; i <= right ; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        while (left > 0 && nums[left-1] > min) left--;
        while (right < nums.length-1 && nums[right+1] < max) right++;

        return right-left+1;
    }
}
