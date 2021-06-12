package com.package1;

import java.util.ArrayList;
import java.util.List;

public class LC144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        dfs(root,result);
        return result;
    }

    private void dfs(TreeNode root, ArrayList<Integer> result){
        if (root == null) return;

        result.add(root.val);
        dfs(root.left,result);
        dfs(root.right,result);
    }
}
