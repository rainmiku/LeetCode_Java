package com.package1;

import java.util.ArrayList;
import java.util.List;

public class LC078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        subsets.add(new ArrayList<>());
        for (int num : nums) {
            int tempSize = subsets.size();
            for (int i = 0; i < tempSize; i++) {
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(num);
                subsets.add(set);
            }
        }

        return subsets;
    }
}
