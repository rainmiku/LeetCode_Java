package com.package1;

public class LC796 {
    public boolean rotateString(String A, String B) {
        if (A == null || B == null || A.length()!=B.length())
            return false;
        String s = A+A;
        int i = s.indexOf(B);
        return (i!=-1);
    }
}
