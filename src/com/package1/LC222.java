package com.package1;

import java.util.ArrayDeque;
import java.util.Queue;

public class LC222 {

    public int countNodes(TreeNode root) {
        int leftDepth = 0;
        int rightDepth = 0;

        TreeNode current = root;
        while (current != null){
            leftDepth++;
            current = current.left;
        }

        current = root;
        while (current != null){
            rightDepth++;
            current = current.right;
        }

        if(leftDepth == rightDepth)
            return (int)Math.pow(2,leftDepth)-1;

        return 1+countNodes(root.left)+countNodes(root.right);
    }

}


