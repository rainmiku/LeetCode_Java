package com.package1;

public class LC1221 {
    public int balancedStringSplit(String s) {
        int result = 0, L = 0, R = 0;
        for (char ch: s.toCharArray()) {
            if (ch == 'L')
                L++;
            if (ch == 'R')
                R++;
            if (L == R && L!=0){
                result++;
                L = 0;
                R = 0;
            }
        }
        return result;
    }
}
