package com.package1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487527&idx=1&sn=9cf2b0d8608ba26ea7c6a5c9b41d05a1&chksm=9bd7ee2faca0673916bf075539bf6fc3c01f3dcc0b298b3f507047692ef5c850ed9cfe82e4e6&scene=21#wechat_redirect
public class LC652 {

    private List<TreeNode> res = new ArrayList<>();
    private HashMap<String,Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        tranverse(root);
        return res;
    }

    public String tranverse(TreeNode root){
        if (root == null){
            return "#";
        }

        String left = tranverse(root.left);
        String right = tranverse(root.right);
        String subTree = left + "," + right + "," + root.val;

        int count = map.getOrDefault(subTree,0);
        if (count == 1){
            res.add(root);
        }
        map.put(subTree,count+1);
        return subTree;
    }

}
