package com.package1;

import java.util.ArrayList;
import java.util.List;

public class LC784 {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        result.add(S);

        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))){
                int n = result.size();
                for (int j = 0; j < n; j++) {
                    char[] chs = result.get(j).toCharArray();
                    if (Character.isLowerCase(chs[i]))
                        chs[i] = Character.toUpperCase(chs[i]);
                    else
                        chs[i] = Character.toLowerCase(chs[i]);
                    result.add(String.valueOf(chs));
                }
            }
        }
        return result;
    }
}
