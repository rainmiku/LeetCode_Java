package com.package1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC030 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s.equals("") || words.length == 0) return result;
        int wordLength = words[0].length();

        HashMap<String,Integer> wordsMap = new HashMap<>();
        for (String word :
                words) {
            wordsMap.put(word,wordsMap.getOrDefault(word,0)+1);
        }

        for (int i = 0; i <= s.length()-words.length * wordLength; i++) {
            HashMap<String,Integer> map = new HashMap<>();
            int start = i, count = 0;
            while (count < words.length){
                String temp = s.substring(start, start+wordLength);
                if (!wordsMap.containsKey(temp)) break;
                map.put(temp,map.getOrDefault(temp,0)+1);
                if (map.get(temp) > wordsMap.get(temp)) break;
                count++;
                start += wordLength;
            }
            if (count < words.length) continue;
            result.add(i);
        }

        return result;
    }
}
