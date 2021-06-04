package com.package1;

import java.util.ArrayDeque;
import java.util.Queue;

public class LC993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            boolean xfound = false;
            boolean yfound = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (x == node.val){
                    xfound = true;
                    continue;
                }
                if (y == node.val){
                    yfound = true;
                    continue;
                }

                boolean isLeftChild = false;
                boolean isRightChild = false;

                if (node.left!=null){
                    queue.add(node.left);
                    if (node.left.val == x || node.left.val == y) isLeftChild = true;
                }
                if (node.right!=null){
                    queue.add(node.right);
                    if (node.right.val == x || node.right.val == y) isRightChild = true;
                }

                if (isLeftChild && isRightChild) return false;
            }
            if (xfound && yfound) return true;
        }
        return false;
    }
}

