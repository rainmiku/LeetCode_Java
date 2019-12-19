package com.package1;

import java.util.Arrays;

public class LC006 {
    public String convert(String s, int numRows) {

        if (numRows <= 1) return s;
        numRows = Math.min(s.length(), numRows);

        String[] level = new String[numRows];
        Arrays.fill(level,"");
        int zig = 1;
        boolean flag = true;
        for(char ch: s.toCharArray()){
            level[zig-1] += ch;
            zig += (flag) ? 1 : -1;
            if (zig == numRows || zig == 1)
                flag = !flag;
        }

        String result = "";
        for (String str: level)
            result += str;
        return result;
    }
}

