package com.package1;

import java.util.HashMap;

public class LC523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (k == 0){
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 0 && nums[i-1] == 0)
                    return true;
            }
            return false;
        }
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i-1]+ nums[i];
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int subsum;
                if (i == 0)
                    subsum = sums[j];
                else
                    subsum = sums[j] - sums[i-1];
                if (subsum % k == 0)
                    return true;
            }
        }
        return false;
    }

    public boolean checkSubarraySumInOn(int[] nums, int k){
        //a[0]+a[1]+ .. a[i] = n1*k+q     ------ x
        // if j > i  a[0]+a[1]+..+a[i]+a[i+1]+...a[j] = n2*k+q  ------ y
        // a[i+1]+a[i+2]+...a[j] = (n2-n1)k    ----- y - x
        if (nums.length <= 1) return false;
        if (k == 0){
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 0 && nums[i-1] == 0)
                    return true;
            }
            return false;
        }


        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        map.put(0,-1);
        for (int i = 0; i < nums.length; i++) {

            sum = sum + nums[i];
             int mod = sum % k;
             if (map.containsKey(mod))
                 if (i - map.get(mod) >= 2)
                     return true;
                 else continue;
             map.put(mod,i);
        }
        return false;
    }
}
