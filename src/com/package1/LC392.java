package com.package1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC392 {
    public boolean isSubsequence(String s, String t) {
        int j=0;
        for (int i = 0; i < s.length(); i++) {
            while (j<t.length() && s.charAt(i) != t.charAt(j))
                j++;
            if (j==t.length())
                return false;
            j++;
        }
        return true;
    }

    public boolean isSubsequenceFast(String s, String t){
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!map.containsKey(ch)){
                map.put(ch, new ArrayList<>());
            }
            map.get(ch).add(i);
        }


        int lastIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) return false;
            int index = binarySearch(map.get(ch), lastIndex);
            if (index < 0) return false;
            lastIndex = index;
        }

        return true;


    }

    private int binarySearch(ArrayList<Integer> indexList, int index){
        int left = 0, right = indexList.size()-1;
        if (indexList.get(right) < index) return -1;
        while (left <= right){
            int middle = (left+right) / 2;
            if (indexList.get(middle) <= index)
                left = middle+1;
            else
                right = middle-1;
        }
        return (left == indexList.size()) ? -1 : indexList.get(left);
    }
}
