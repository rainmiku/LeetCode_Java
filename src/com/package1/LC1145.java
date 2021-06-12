package com.package1;

public class LC1145 {
    private int left, right;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        countNode(root,x);
        int parent = n - left - right -1;
        return Math.max(Math.max(left,right),parent) > n / 2;
    }

    private int countNode (TreeNode root, int x){
        if (root == null) return 0;
        int l = countNode(root.left,x);
        int r = countNode(root.right,x);

        if (root.val == x) {
            left = l;
            right = r;
        }

        return l+r+1;
    }
}
