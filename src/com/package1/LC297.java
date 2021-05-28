package com.package1;
import java.util.LinkedList;

public class LC297 {
    // Encodes a tree to a single string.

    //https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485871&idx=1&sn=bcb24ea8927995b585629a8b9caeed01&chksm=9bd7f7a7aca07eb1b4c330382a4e0b916ef5a82ca48db28908ab16563e28a376b5ca6805bec2&scene=21#wechat_redirect
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append("null").append(",");
            return;
        }

        sb.append(root.val).append(",");

        serialize(root.left,sb);
        serialize(root.right,sb);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();

        for (String node: data.split(",")) {
            nodes.addLast(node);
        }

        return des(nodes);
    }

    private TreeNode des(LinkedList<String> nodes){
        if (nodes.isEmpty())
            return null;

        String first = nodes.removeFirst();
        if (first.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = des(nodes);
        root.right = des(nodes);

        return root;
    }
}
