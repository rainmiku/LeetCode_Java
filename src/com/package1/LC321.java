package com.package1;

public class LC321 {
    //https://web.archive.org/web/20160120093629/http://algobox.org/create-maximum-number/

    //1. Create the maximum number of one array
    //2. Create the maximum number of two array using all of their digits.

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int ans[] = new int[k];
        int m = nums1.length;
        int n = nums2.length;

        for (int i = Math.max(0, k-n); i <= k && i <= m; i++) {
            int[] temp = merge(maxArray(nums1,i),maxArray(nums2,k-i),k);
            ans = greater(temp,ans,0,0) ? temp : ans;
        }

        return ans;

    }

    private int[] merge(int[] nums1, int[] nums2, int k){
        int[] ans = new int[k];
        for (int s = 0, i = 0, j = 0; s < k; s++) {
            ans[s] = greater(nums1, nums2, i, j) ? nums1[i++] : nums2[j++];
        }
        return ans;
    }

    private int[] maxArray(int[] nums, int k){
        int[] ans = new int[k];
        for (int i = 0,top = 0; i < nums.length; i++) {
            while (top > 0 && ans[top-1] < nums[i] && nums.length - i + top > k) top--;
            if (top < k) ans[top++] = nums[i];
        }
        return ans;
    }

    private boolean greater(int[] nums1, int[] nums2, int i, int j){

        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]){
            i++;
            j++;
        }
        if (i == nums1.length) return false;
        if (j == nums2.length) return true;
        return nums1[i] > nums2[j];
    }
}
