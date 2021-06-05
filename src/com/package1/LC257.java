package com.package1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC257 {
    private List<String> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<Integer> path = new LinkedList<>();
        findPath(root,path);
        return list;
    }

    private void findPath(TreeNode root, LinkedList<Integer> path){
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <path.size()-1 ; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(root.val);
            list.add(sb.toString());
            return;
        }
        if (root.left != null){
            findPath(root.left,path);
            path.removeLast();
        }

        if (root.right != null){
            findPath(root.right,path);
            path.removeLast();
        }

    }
}
