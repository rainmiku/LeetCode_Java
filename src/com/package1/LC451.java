package com.package1;

import java.util.ArrayList;
import java.util.HashMap;

public class LC451 {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int maxFreq = 0;
        for (char ch : s.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxFreq = Math.max(maxFreq,map.get(ch));
        }

        ArrayList<Character>[] bucket = new ArrayList[maxFreq+1];
        for (char ch : map.keySet()) {
            int freq = map.get(ch);
            if (bucket[freq] == null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(ch);
        }

        StringBuilder res = new StringBuilder();
        for (int i = maxFreq; i >=1 ; i--) {
            if (bucket[i] == null) continue;
            for (char ch : bucket[i]) {
                res.append(String.valueOf(ch).repeat(i));
            }
        }
        return res.toString();
    }
}
