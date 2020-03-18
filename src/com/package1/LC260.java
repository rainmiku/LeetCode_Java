package com.package1;

public class LC260 {
    public int[] singleNumber(int[] nums) {
        int n1xn2 = 0;
        for (int num : nums) {
            n1xn2 ^= num;
        }

        int rightDiffBit = 1;
        while ((rightDiffBit & n1xn2) == 0)
            rightDiffBit = rightDiffBit << 1;

        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((rightDiffBit & num) == 0)
                num1 ^= num;
            else
                num2 ^= num;
        }
        return new int[]{num1, num2};
    }
}
