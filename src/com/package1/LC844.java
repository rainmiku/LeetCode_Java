package com.package1;

public class LC844 {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length()-1, j=T.length()-1;
        while (i>=0 || j>=0){
            i = getNextCharIndex(S, i);
            j = getNextCharIndex(T, j);

            if (i<0 && j>=0 || i>=0 && j<0)
                return false;

            if (i>=0 && j>=0 && S.charAt(i) != T.charAt(j))
                return false;
            i--;
            j--;
        }
        return true;
    }
    private static int getNextCharIndex(String str, int i){
        if (i < 0) return -1;
        int count = 0;
        while (i >= 0 && str.charAt(i) == '#'){
            count++;
            i--;
        }
        while (i >= 0 && count > 0){
            if (str.charAt(i) == '#')
                count++;
            else
                count--;
            i--;
        }
        if (i < 0) return -1;
        if (str.charAt(i) == '#') return getNextCharIndex(str,i);
        return i;
    }
}
