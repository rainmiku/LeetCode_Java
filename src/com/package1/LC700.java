package com.package1;

public class LC700 {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode current = root;
        while (current != null){
            if (current.val == val) return current;
            if (current.val > val) current = current.left;
            else current = current.right;
        }
        return null;
    }
}
