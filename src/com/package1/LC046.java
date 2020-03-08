package com.package1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(new LinkedList<>());

        for (int num : nums) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                List<Integer> list = queue.poll();
                for (int j = 0; j <= list.size(); j++) {
                    List<Integer> newList = new LinkedList<>(list);
                    newList.add(j,num);
                    if (newList.size() == nums.length){
                        result.add(newList);
                    }else {
                        queue.offer(newList);
                    }
                }
            }
        }
        return result;
    }
}
