package com.package1;

import java.util.ArrayDeque;
import java.util.Queue;

class TNode {
    public int val;
    public TNode left;
    public TNode right;
    public TNode next;

    public TNode() {}

    public TNode(int _val) {
        val = _val;
    }

    public TNode(int _val, TNode _left, TNode _right, TNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class LC116 {
    public TNode connect(TNode root) {
        if (root == null) return null;

        Queue<TNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            TNode pre = null;
            for (int i = 0; i < levelSize; i++) {
                TNode current = queue.poll();
                if (current.left!=null)
                    queue.offer(current.left);
                if (current.right!=null)
                    queue.offer(current.right);
                if (pre != null)
                    pre.next = current;
                pre = current;
            }
        }

        return root;
    }
}
