package com.package1;

public class LC958 {
    public boolean isCompleteTree(TreeNode root) {
        return isCompleteTree(root,0,getNodesCount(root));
    }

    private boolean isCompleteTree(TreeNode root, int i, int n){
        if (root == null) return true;
        if (i >= n) return false;
        return isCompleteTree(root.left, i*2+1, n) && isCompleteTree(root.right, i*2+2, n);
    }

    private int getNodesCount(TreeNode root){
        if (root == null) return 0;
        return getNodesCount(root.left) + getNodesCount(root.right) + 1;
    }
}
