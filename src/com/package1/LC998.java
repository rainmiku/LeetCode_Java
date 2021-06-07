package com.package1;

public class LC998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode father = findRightClosest(root,val);
        TreeNode appended = new TreeNode(val);

        if (father == null){
            appended.left = root;
            return appended;
        }

        TreeNode current = father.right;
        father.right = appended;
        appended.left = current;

        return root;
    }

    private TreeNode findRightClosest(TreeNode root, int val){
        if (root == null) return null;
        TreeNode father = null;
        TreeNode current = root;
        while (current != null){
            if (current.val > val){
                father = current;
                current = current.right;
            }
            else return father;
        }
        return father;
    }

}
