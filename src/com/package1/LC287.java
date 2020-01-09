package com.package1;

public class LC287 {
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length-1;

        while (left < right){
            int middle = (left+right)/2;
            int count = 0;
            for (int num: nums) {
                if (num <= middle) count++;
            }
            if (count <= middle)
                left = middle+1;
            else
                right = middle;
        }

        return left;

    }

}
