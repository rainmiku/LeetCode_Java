package com.package1;

public class LC1017 {
    public String baseNeg2(int N) {
        if (N == 0) return "0";
        String res = "";
        while (N != 0){
            int yu = N % 2;
            char ch = (char)(Math.abs(yu)+'0');
            res = ch + res;
            if (yu < 0)
                N = (N+N%-2) / -2;
            else
                N = N/-2;

        }
        return res;
    }
}
