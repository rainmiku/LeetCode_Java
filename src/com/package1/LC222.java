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

    public int countNodes(TreeNode root) {

        countNodes(root,0);

        return size;
    }

    private void countNodes(TreeNode root, int d){
        if (root == null)
            return;
        size++;
        countNodes(root.left,d+1);
        countNodes(root.right,d+1);
    }


}


