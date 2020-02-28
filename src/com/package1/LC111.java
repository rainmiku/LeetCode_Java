package com.package1;

import java.util.ArrayDeque;
import java.util.Queue;

public class LC111 {
    public int minDepth(TreeNode root) {
        int level = 0;
        if (root == null) return level;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            level++;
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (current.right == null && current.left == null)
                    return level;
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
        }
        return level;
    }
}
