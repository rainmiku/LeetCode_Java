package com.package1;

public class LC004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (n < m) return findMedianSortedArrays(nums2,nums1);

        int left = 0;
        int right = m;
        while (left <= right){
            int x = (left+right)/2;
            int y = (m+n+1) / 2 - x;
            int maxLx = (x == 0) ? Integer.MIN_VALUE : nums1[x-1];
            int minRx = (x == m) ? Integer.MAX_VALUE : nums1[x];
            int maxLy = (y == 0) ? Integer.MIN_VALUE : nums2[y-1];
            int minRy = (y == n) ? Integer.MAX_VALUE : nums2[y];
            if (maxLx <= minRy && maxLy <= minRx){
                if ((m+n) % 2 != 0){
                    return Math.max(maxLx, maxLy);
                }
                else{
                    return (Math.max(maxLx, maxLy) + Math.min(minRx, minRy)) / 2.0;
                }
            }
            else if (maxLx > minRy){
                right = x-1;
            }
            else{
                left = x+1;
            }
        }
        return -1;
    }
}
