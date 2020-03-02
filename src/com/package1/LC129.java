package com.package1;

public class LC129 {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root,0);
    }
    private int sumNumbers(TreeNode root, int current){
        if (root == null) return 0;
        current = current*10+root.val;
        if (root.left == null & root.right == null){
            return current;
        }
        return sumNumbers(root.left, current) + sumNumbers(root.right, current);
    }
}
