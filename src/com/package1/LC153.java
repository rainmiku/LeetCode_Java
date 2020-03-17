package com.package1;

public class LC153 {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length-1;
        while (start <= end){
            int mid = start + (end - start) /2;
            if (mid > start && nums[mid] < nums[mid-1])
                return nums[mid];
            if (mid < end && nums[mid] > nums[mid+1])
                return nums[mid+1];
            if (nums[start] < nums[mid])
                start = mid+1;
            else
                end = mid-1;
        }
        return nums[0];
    }
}
