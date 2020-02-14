package com.package1;

import java.util.HashSet;

public class LC003 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();

        for (right = 0; right < s.length(); right++) {
            char rc = s.charAt(right);
            while (set.contains(rc))
            {
                char lc = s.charAt(left);
                set.remove(lc);
                left++;
            }
            set.add(rc);
            max = Math.max(max, set.size());
        }
        return max;
    }
}
