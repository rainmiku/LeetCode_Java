package com.package1;

import java.util.ArrayList;
import java.util.List;

public class LC655 {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> tree = new ArrayList<>();
        int depth = getDepth(root);
        int width =(int) Math.pow(2,depth)-1;

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < width; i++) list.add("");
        for (int i = 0; i < depth; i++) tree.add(new ArrayList<>(list));

        draw(root, tree,0,0,width-1);

        return tree;
    }

    private void draw(TreeNode root, List<List<String>> tree, int depth, int left, int right){
        if (root == null) return;
        int mid = (left + right) / 2;
        tree.get(depth).set(mid, String.valueOf(root.val));

        draw(root.left, tree, depth+1, left, mid-1);
        draw(root.right, tree, depth+1, mid+1, right);
    }

    private int getDepth(TreeNode root){
        if (root == null) return 0;

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        return Math.max(leftDepth, rightDepth)+1;
    }
}
