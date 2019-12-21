package com.package1;

import java.util.ArrayList;
import java.util.List;

public class LC821 {
    public int[] shortestToChar(String S, char C) {
        List<Integer> pos = new ArrayList<>();
        char[] s = S.toCharArray();

        for (int i = 0; i < s.length; i++) {
            if (s[i] == C)
                pos.add(i);
        }

        int[] result = new int[s.length];

        int left = -1;
        int right = 0;
        for (int i = 0; i < s.length; i++) {
            if (right == pos.size()){
                result[i] = i - pos.get(left);
                continue;
            }
            if (i == pos.get(right)){
                result[i] = 0;
                left = right;
                right = right+1;
                continue;
            }
            if (left < 0){
                result[i] = pos.get(right) - i;
                continue;
            }
            result[i] = Math.min(i - pos.get(left), pos.get(right) - i);
        }

        return result;
    }
}
