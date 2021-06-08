package com.package1;

public class LC979 {
    private int moves = 0;
    public int distributeCoins(TreeNode root) {
        distributeCoinsS(root);
        return moves;
    }
    private int distributeCoinsS(TreeNode root){
        if (root == null) return 0;
        int left = distributeCoinsS(root.left);
        int right = distributeCoinsS(root.right);

        moves += Math.abs(left) + Math.abs(right);
        return root.val+left + right - 1;
    }
}
