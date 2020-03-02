package com.package1;

public class LC124 {
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findSum(root);
        return maxSum;
    }

    private int findSum(TreeNode root) {
        if (root == null)
            return 0;

        int left = findSum(root.left);
        int right = findSum(root.right);

        left = Math.max(left, 0);
        right = Math.max(right, 0);

        maxSum = Math.max(left + right + root.val, maxSum);

        return Math.max(left, right) + root.val;
    }
}
