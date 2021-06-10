package com.package1;


import java.util.ArrayList;

public class LC662 {
    public int widthOfBinaryTree(TreeNode root) {
        return widthOfBinaryTree(root,1,1,new ArrayList<>(),new ArrayList<>());
    }

    private int widthOfBinaryTree(TreeNode root, int depth, int i, ArrayList<Integer> left, ArrayList<Integer> right){
        if (root == null) return 0;
        //如果是新的一行的话，左右都从这个点起
        if (left.size() == depth){
            left.add(i);
            right.add(i);
        }
        //否则持续更新右边
        else right.set(depth,i);

        int wid =right.get(depth)-left.get(depth)+1;
        int leftWid = widthOfBinaryTree(root.left,depth+1,2*i,left,right);
        int rightWid = widthOfBinaryTree(root.right, depth+1, 2*i+1,left,right);

        return Math.max(wid,Math.max(leftWid,rightWid));
    }

}
