package com.package1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;

public class LC621 {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map = new HashMap<>();
        ArrayList<Character> list = new ArrayList<>();

        for (char ch: tasks) {
            if (!map.containsKey(ch))
                list.add(ch);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        ArrayList<Character> sorted = list.stream().sorted(Comparator.comparing(map::get)).collect(Collectors.toCollection(ArrayList::new));


        return 0;


    }
}
