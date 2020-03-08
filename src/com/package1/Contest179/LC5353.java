package com.package1.Contest179;

public class LC5353 {
    public int numTimesAllBlue(int[] light) {
        int max = 0,result = 0;
        for (int i = 0; i < light.length; i++) {
            max = Math.max(max, light[i]);
            if (i+1 == max) result++;
        }
        return result;
    }
}
