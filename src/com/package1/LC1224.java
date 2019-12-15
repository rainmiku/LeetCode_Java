package com.package1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LC1224 {
    public int maxEqualFreq(int[] nums) {
        Map<Integer,Integer> occurrences = new HashMap<>();
        Map<Integer, Integer> countOccur = new HashMap<>();

        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num,0) + 1);
        }

        for (int count:occurrences.values()) {
            countOccur.put(count,countOccur.getOrDefault(count,0)+1);
        }

        for (int i = nums.length-1; i >= 0; i--) {
            if (valid(countOccur))
                return i+1;
            int count = occurrences.get(nums[i]);

            countOccur.put(count,countOccur.get(count)-1);
            if (count > 1)
                countOccur.put(count-1, countOccur.getOrDefault(count-1,0)+1);

            occurrences.put(nums[i],occurrences.get(nums[i])-1);

            if (countOccur.get(count) == 0)
                countOccur.remove(count);
            if (occurrences.get(nums[i]) == 0)
                occurrences.remove(nums[i]);
        }

        return 0;
    }

    private boolean valid(Map<Integer,Integer> map){
        if (map.size() == 1)
            return map.keySet().iterator().next()==1||map.values().iterator().next() == 1;

        if (map.size() > 2)
            return false;

        int maxOccur = Collections.max(map.keySet());
        int minOccur = Collections.min(map.keySet());

        return (maxOccur - minOccur == 1 && map.get(maxOccur) == 1)
                || (minOccur == 1 && map.get(minOccur) == 1);
    }

}
