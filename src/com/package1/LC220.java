package com.package1;


import java.util.TreeSet;

public class LC220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (nums.length < 2 || k == 0) return false;
        TreeSet<Long> treeSet = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            long tplus = (long)nums[i]+(long)t;
            long tminus = (long)nums[i]-(long)t;
            if(treeSet.floor(tplus) != null && treeSet.floor(tplus) >= tminus )
                return true;
            treeSet.add((long) nums[i]);
            if (i>=k)
                treeSet.remove((long)nums[i-k]);
        }
        return false;
    }
}
