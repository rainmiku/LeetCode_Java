package com.package1;

public class LC105 {

    int order = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,0);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int rootInPre){
        if (inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[rootInPre]);
        if (inorder.length == 1) return root;

        int rootInIn = find(inorder,root.val);
        int[] leftIn = new int[rootInIn];
        for (int i = 0; i < rootInIn; i++) {
            leftIn[i] = inorder[i];
        }
        int[] rightIn = new int[inorder.length-rootInIn-1];
        for (int i = rootInIn+1; i <inorder.length ; i++) {
            rightIn[i-rootInIn-1] = inorder[i];
        }

        if (leftIn.length>0) root.left = buildTree(preorder,leftIn,++order);
        if (rightIn.length>0) root.right = buildTree(preorder,rightIn,++order);

        return root;

    }

    private int find(int[] inorder,int value){
        for (int i = 0; i < inorder.length; i++) {
            if (value == inorder[i])
                return i;
        }
        return -1;
    }

}
