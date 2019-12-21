package com.package1;

import javax.print.CancelablePrintJob;
import java.util.*;

public class LC049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList> map = new HashMap<>();
        for (String str:strs) {
            String sort = sortedString(str);
            if (!map.containsKey(sort)){
                map.put(sort, new ArrayList<>());
            }
            map.get(sort).add(str);
        }
        return new ArrayList(map.values());
    }

    private String sortedString(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
