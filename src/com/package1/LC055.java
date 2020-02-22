package com.package1;

public class LC055 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int lastZero = -1;
        for (int i = nums.length-2; i>=0; i--) {
            if (nums[i] == 0 && lastZero == -1) {
                lastZero = i;
                continue;
            }
            if (lastZero - i < nums[i])
                lastZero = -1;
        }
        return lastZero == -1;
    }
}
