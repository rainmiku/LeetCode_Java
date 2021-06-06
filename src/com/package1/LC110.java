package com.package1;

public class LC110 {
    private boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        getDepth(root);
        return balanced;
    }

    private int getDepth(TreeNode root){
        if (root == null || !balanced) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);

        if (Math.abs(left-right) > 1) {
            balanced = false;
            return 0;
        }
        return Math.max(left,right)+1;
    }

}
