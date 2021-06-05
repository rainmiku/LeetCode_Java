package com.package1;

public class LC563 {
    private int ans = 0;
    public int findTilt(TreeNode root) {
        childSum(root);
        return ans;
    }

    private int childSum(TreeNode root){
        if (root == null) return 0;
        int left = childSum(root.left);
        int right = childSum(root.right);
        ans += Math.abs(left - right);
        return left+right+root.val;
    }


}
