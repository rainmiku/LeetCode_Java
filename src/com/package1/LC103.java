package com.package1;

import java.util.*;

public class LC103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root==null) return result;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        boolean odd = true;
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (current.left!=null){
                    queue.add(current.left);
                }
                if (current.right!=null){
                    queue.add(current.right);
                }
                if (odd) list.add(current.val);
                else list.add(0,current.val);
            }
            result.add(list);
            odd = !odd;
        }
        return result;
    }
}
