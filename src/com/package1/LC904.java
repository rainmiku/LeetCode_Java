package com.package1;

import java.util.HashMap;

public class LC904 {
    public int totalFruit(int[] tree) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, max = 0;

        for (int right = 0; right < tree.length; right++) {
            int rf = tree[right];
            map.put(rf, map.getOrDefault(rf,0)+1);

            while (map.size() > 2 && left < right){
                int lf = tree[left];
                map.put(lf,map.getOrDefault(lf,0)-1);
                if (map.get(lf) == 0)
                    map.remove(lf);
                left++;
            }

            max = Math.max(max,right-left+1);
        }
        return max;
    }
}
