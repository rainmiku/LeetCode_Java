package com.package1;

import java.util.ArrayList;
import java.util.List;

public class LC094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorderTraversal(root,list);
        return list;
    }

    public void inorderTraversal(TreeNode root, ArrayList<Integer> list){
        if (root == null) return;
        inorderTraversal(root.left,list);
        list.add(root.val);
        inorderTraversal(root.right,list);
    }
}
