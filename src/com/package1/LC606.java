package com.package1;

public class LC606 {

    String s = "";
    public String tree2str(TreeNode t) {

        trans(t);
        return s;
    }

    private void trans(TreeNode t){
        if (t == null)
            return;

        s = s+t.val;
        if (t.left == null && t.right == null)
            return;

        if (t.right == null){
            s = s+'(';
            trans(t.left);
            s = s+')';
            return;
        }
        s = s+'(';
        trans(t.left);
        s = s+')';

        s = s+'(';
        trans(t.right);
        s = s+')';
    }
}
