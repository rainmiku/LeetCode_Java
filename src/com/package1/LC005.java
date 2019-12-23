package com.package1;
public class LC005 {
    public String longestPalindrome(String s) {

        if (s == null || s.equals(""))
            return "";

        boolean [][] f = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            f[i][i] = true;
        }

        int maxi = 0,maxj = 0,maxlen = 0;
        for (int i = s.length()-1; i >=0 ; i--) {
            for (int j = i+1; j < s.length(); j++) {
                f[i][j] = (j-i > 1) ? (f[i+1][j-1] && s.charAt(i) == s.charAt(j)) : (s.charAt(i) == s.charAt(j));
                if (f[i][j] && j - i > maxlen){
                    maxj = j;
                    maxi = i;
                    maxlen = maxj - maxi;
                }
            }
        }
        return s.substring(maxi,maxj+1);
    }
}
