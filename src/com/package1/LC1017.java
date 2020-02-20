package com.package1;

public class LC1017 {
    public String baseNeg2(int N) {
        if (N == 0) return "0";
        StringBuilder res = new StringBuilder();
        while (N != 0){
            int yu = N % 2;
            char ch = (char)(Math.abs(yu)+'0');
            res.append(ch);
            if (yu < 0)
                N--;
            N = N/-2;
        }
        return res.reverse().toString();
    }
}
