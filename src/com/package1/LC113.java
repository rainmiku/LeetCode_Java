package com.package1;

import java.util.ArrayList;
import java.util.List;

public class LC113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> allPaths  = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPaths(root,sum,currentPath,allPaths);
        return allPaths;
    }

    private void findPaths(TreeNode root, int sum,  List<Integer> currentPath, List<List<Integer>> allPaths){
        if (root == null)
            return;

        currentPath.add(root.val);
        if (root.val == sum && root.left == null && root.right == null){
            allPaths.add(new ArrayList<>(currentPath));
        }
        else {
            findPaths(root.left,sum-root.val,currentPath,allPaths);
            findPaths(root.right,sum-root.val,currentPath,allPaths);
        }
        currentPath.remove(currentPath.size()-1);
    }
}
