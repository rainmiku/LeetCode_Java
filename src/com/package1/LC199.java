package com.package1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class LC199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (current.left!=null)
                    queue.offer(current.left);
                if (current.right!=null)
                    queue.offer(current.right);

                if (i == levelSize-1)
                    result.add(current.val);
            }
        }
        return result;

    }
}
