package com.package1.Contest245;

import java.util.HashMap;

public class LC5874 {
    public boolean makeEqual(String[] words) {
        if (words.length <= 1) return true;
        HashMap<Character, Integer> map = new HashMap<>();

        for (var word : words) {
            for (var ch : word.toCharArray()) {
                map.put(ch, map.getOrDefault(ch,0)+1);
            }
        }


        for (var count: map.values()) {
            if (count % words.length != 0) return false;
        }


        return true;
    }

}
