package com.package1.Contest178;

import com.package1.ListNode;
import com.package1.TreeNode;

public class LC5346 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null || head == null) return false;
        return isSub(head,root) || isSubPath(head,root.left) || isSubPath(head,root.right);

    }
    private boolean isSub(ListNode head, TreeNode root){
        if (root==null) return false;
        if (root.val == head.val && head.next == null) return true;
        return (root.val == head.val && (isSub(head.next,root.left) || isSub(head.next,root.right)));
    }

}
