package com.package1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC244 {
    static class WordDistance {
        HashMap<String, List<Integer>> map;

        public WordDistance(String[] wordsDict) {
            map = new HashMap<>();
            for (int i=0;i<wordsDict.length;i++){
                String word = wordsDict[i];
                if (!map.containsKey(word)){
                    map.put(word, new ArrayList<>());
                }
                map.get(word).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            var list1 = map.get(word1);
            var list2 = map.get(word2);


            int ans = Integer.MAX_VALUE;
            int i=0;
            int j=0;

            while(i<list1.size() && j < list2.size()){
                if (list1.get(i) < list2.get(j)){
                    ans = Math.min(ans, list2.get(j)-list1.get(i));
                    i++;
                }
                else{
                    ans = Math.min(ans,list1.get(i)-list2.get(j));
                    j++;
                }
            }
            return ans;
        }
    }
}
