package com.package1;

import java.util.HashMap;

public class LC424 {
    public int characterReplacement(String s, int k) {
        int left=0, maxLetterCount=0, max = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char rc = s.charAt(right);
            map.put(rc, map.getOrDefault(rc, 0)+1);
            maxLetterCount = Math.max(maxLetterCount,map.get(rc));

            if (right-left+1 - maxLetterCount > k){
                char lc = s.charAt(left);
                map.put(lc,map.get(lc)-1);
                if (map.get(lc) == 0)
                    map.remove(lc);
                left++;
            }
            max = Math.max(right-left+1,max);
        }
        return max;
    }
}
