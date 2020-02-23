package com.package1;

public class LC041 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]>0 && nums[i] <= nums.length && nums[i]!=i+1 && nums[nums[i]-1]!=nums[i])
                swap(nums,i,nums[i]-1);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1)
                return i+1;
        }
        return nums.length+1;
    }
    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

}

