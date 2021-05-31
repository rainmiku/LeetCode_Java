package com.package1;

import java.util.LinkedList;

public class LC449 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }
    private void serialize(TreeNode root, StringBuilder sb){
        if (root == null) return;
        sb.append(root.val).append(",");
        serialize(root.left,sb);
        serialize(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        LinkedList<Integer> nodes = new LinkedList<>();
        for (var node:data.split(",")) {
            nodes.addLast(Integer.parseInt(node));
        }

        return deserialize(nodes,-1,10001);

    }

    private TreeNode deserialize(LinkedList<Integer> nodes, int min, int max){
        if (nodes.isEmpty()) return null;
        int first = nodes.getFirst();
        if (first < min || first > max) return null;
        TreeNode root = new TreeNode(nodes.removeFirst());
        root.left = deserialize(nodes, min, root.val);
        root.right = deserialize(nodes, root.val, max);
        return root;
    }
}
