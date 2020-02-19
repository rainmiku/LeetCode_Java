package com.package1;

public class LC075 {
    public void sortColors(int[] nums) {
        int low = 0, high = nums.length-1;
        int i = 0;

        while (i <= high){
            if (nums[i] == 0)
                swap(nums,low++,i++);
            else if (nums[i] == 1)
                i++;
            else
                swap(nums,high--,i);
        }
    }
    private void swap (int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
