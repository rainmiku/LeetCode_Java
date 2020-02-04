package com.package1;

import java.util.ArrayList;
import java.util.HashMap;

public class LC508 {
    private int maxFreq;
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> sumFreq = new HashMap<>();

        dfs(root,sumFreq);

        ArrayList<Integer> list = new ArrayList<>();
        for (int sum: sumFreq.keySet()){
            if (sumFreq.get(sum) == maxFreq)
                list.add(sum);
        }

        return list.stream().mapToInt(i->i).toArray();
    }

    private void dfs(TreeNode root, HashMap<Integer, Integer> sumFreq){
        if (root == null) return;

        dfs(root.left, sumFreq);
        dfs(root.right,sumFreq);

        int left = (root.left != null) ? root.left.val : 0;
        int right = (root.right != null) ? root.right.val : 0;

        int sum = left + right + root.val;
        sumFreq.put(sum, sumFreq.getOrDefault(sum,0)+1);
        root.val = sum;
        maxFreq = Math.max(sumFreq.get(sum), maxFreq);

    }
}
