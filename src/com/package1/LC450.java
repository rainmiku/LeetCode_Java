package com.package1;

public class LC450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode current = root;
        TreeNode father = new TreeNode(Integer.MAX_VALUE);
        father.left = root;
        TreeNode pre = father;
        boolean isLeftChild = true;
        while (current != null){
            if (key > current.val){
                father = current;
                current = current.right;
                isLeftChild = false;
            }
            else if (key < current.val){
                father = current;
                current = current.left;
                isLeftChild = true;
            }
            else {
                if (current.left == null && current.right == null){
                    if (isLeftChild) father.left = null;
                    else father.right = null;
                    break;
                }else {
                    TreeNode mostLeftNode = findMostLeftNode(current.right);
                    if (mostLeftNode == null) {
                        if (isLeftChild) father.left = current.left;
                        else father.right = current.left;
                    }
                    else{
                         mostLeftNode.left = current.left;
                        if (isLeftChild) father.left = current.right;
                        else father.right = current.right;

                    }
                }
                break;
            }
        }
        return pre.left;
    }

    private TreeNode findMostLeftNode(TreeNode node){
        if (node == null) return null;
        TreeNode current = node;
        while (current.left != null) current = current.left;
        return current;
    }
}
