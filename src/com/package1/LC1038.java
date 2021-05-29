package com.package1;

public class LC1038 {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        convert(root);
        return root;
    }

    private void  convert(TreeNode root){
        if (root == null) return;

        convert(root.right);

        sum += root.val;
        root.val = sum;

        convert(root.left);
    }
}
