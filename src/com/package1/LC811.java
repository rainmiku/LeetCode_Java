package com.package1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String request: cpdomains) {
            String[] temp = request.split(" ");
            int times = Integer.parseInt(temp[0]);
            String[] levels = temp[1].split("\\.");

            String str = levels[levels.length-1];
            for (int i = levels.length-2; i >= 0 ; i--){
                str = levels[i]+"."+str;
                levels[i] = str;
            }


            for (var level: levels) {
                map.put(level,map.getOrDefault(level,0)+times);
            }
        }

        ArrayList<String> list = new ArrayList<>();
        for (var level: map.keySet())
            list.add(map.get(level) + " " + level);


        return list;

    }
}
