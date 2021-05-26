package com.package1;

public class LC114 {

    //https://labuladong.gitee.io/algo/2/18/20/
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode cuurent = root;
        while (cuurent.right != null)
            cuurent = cuurent.right;
        cuurent.right = right;
    }
}
