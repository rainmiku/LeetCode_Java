package com.package1;

import java.util.ArrayList;

public class LC1313 {
    public int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length / 2; i++) {
            int a = nums[2*i];
            int b = nums[2*i+1];

            for (int j = 0; j < a; j++)
                list.add(b);

        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
