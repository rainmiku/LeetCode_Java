package com.package1;

public class LC136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num :
                nums) {
            result ^= num;
        }
        return result;
    }
}
