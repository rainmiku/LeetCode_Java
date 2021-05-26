package com.package1;

public class LC654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constuct(nums,0,nums.length-1);
    }

    public TreeNode constuct(int[] nums, int l, int r){
        if (l == r) return new TreeNode(nums[l]);
        if (l > r) return null;
        int maxIndex=-1, max = 0;
        for (int i = l; i <= r; i++) {
            if (nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = constuct(nums,l,maxIndex-1);
        root.right = constuct(nums,maxIndex+1,r);
        return root;
    }
}
