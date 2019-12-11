package com.package1;

import java.util.ArrayDeque;
import java.util.Queue;

public class LC222 {


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    private int size = 0;
    private int depth = 0;
    public int countNodes(TreeNode root) {

        getDepth(root,0);
        countNodes(root,0);

        return size;
    }

    private void countNodes(TreeNode root, int d){
        if (root == null) return;
        if (d == depth-1){
            size++;
            int count = getCountOfChild(root);
            size += count;
            return;
        }
        size++;
        countNodes(root.left,d+1);
        countNodes(root.right,d+1);
    }

    private void getDepth(TreeNode root, int d){
        if (root == null){
            depth = d-1;
            return;
        }
        getDepth(root.left, d+1);
    }

    private int getCountOfChild(TreeNode root){
        int count = 0;
        if (root.left != null) count++;
        if (root.right != null) count++;
        return count;
    }

}


