package com.package1;

public class LC230 {
    private int ks = 0, ans = -1, kf = 0;
    public int kthSmallest(TreeNode root, int k) {
        ks = k;
        kthSmallest(root);
        return ans;
    }

    public void kthSmallest(TreeNode root){
        if (root == null || ans >= 0) return;

        kthSmallest(root.left);
        kf++;
        if (kf == ks) {
            ans = root.val;
            return;
        }
        kthSmallest(root.right);

    }
}
