package com.package1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC241 {
    private HashMap<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input))
            return map.get(input);
        List<Integer> result = new ArrayList<>();
        if(!input.contains("+") && !input.contains("-") && !input.contains("*"))
            result.add(Integer.parseInt(input));
        else {
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (Character.isDigit(ch)) continue;
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for (int l : left) {
                    for (int r : right) {
                        if (ch == '+')
                            result.add(l+r);
                        else if (ch == '-')
                            result.add(l-r);
                        else if (ch == '*')
                            result.add(l*r);
                    }
                }
            }
        }
        map.put(input,result);
        return result;
    }
}
