package com.package1;

public class LC543 {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        findHeight(root);
        return diameter;
    }
    public int findHeight(TreeNode root){
        if (root == null)
            return 0;

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        diameter = Math.max(leftHeight+rightHeight,diameter);

        return Math.max(leftHeight,rightHeight)+1;
    }
}
