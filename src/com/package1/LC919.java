package com.package1;

import java.util.ArrayList;

class CBTInserter {
    private ArrayList<TreeNode> treeNodes = new ArrayList<>();
    public CBTInserter(TreeNode root) {
        int size = getTreeSize(root);
        for (int i = 1; i <= size; i++) {
            treeNodes.add(null);
        }
        buildArray(root,0);
    }

    public int insert(int v) {
        int size = treeNodes.size();
        TreeNode node = new TreeNode(v);
        treeNodes.add(node);
        if (size % 2 == 1)
            treeNodes.get((size-1)/2).left = node;
        else
            treeNodes.get((size-1)/2).right = node;
        return treeNodes.get((size-1)/2).val;
    }

    public TreeNode get_root() {
        return treeNodes.get(0);
    }

    private int getTreeSize(TreeNode root){
        if (root == null) return 0;
        return getTreeSize(root.left) + getTreeSize(root.right) + 1;
    }

    private void buildArray(TreeNode root,int i){
        if (root == null) return;
        treeNodes.set(i,root);
        buildArray(root.left,i*2+1);
        buildArray(root.right,i*2+2);
    }

}
