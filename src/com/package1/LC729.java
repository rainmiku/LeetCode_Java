package com.package1;

public class LC729 {

    class TreeNode{
        private int start;
        private int end;
        TreeNode left;
        TreeNode right;

        public TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private TreeNode root = null;
    private boolean isAdded = false;

    public boolean book(int start, int end) {
        isAdded = false;
        root = book(start,end,root);
        return isAdded;

    }

    private TreeNode book(int start, int end, TreeNode root){
        if (root == null){
            isAdded = true;
            return new TreeNode(start,end);
        }

        if (end <= root.start) {
            root.left = book(start, end, root.left);

        }else if (start >= root.end) {
            root.right = book(start, end, root.right);
        }

        return root;
    }

}
