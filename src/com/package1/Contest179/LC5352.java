package com.package1.Contest179;

public class LC5352 {
    public String generateTheString(int n) {
        StringBuilder result = new StringBuilder();
        if (n % 2 == 0){
            if (n == 0) return "";
            if (n % 4 == 0){
                result.append("a".repeat(Math.max(0, n / 2 - 1)));
                result.append("b".repeat(Math.max(0, n / 2 + 1)));
            } else{
                result.append("a".repeat(Math.max(0, n / 2)));
                result.append("b".repeat(Math.max(0, n / 2)));
            }

        }
        else{
            return generateTheString(n-1)+'c';
        }
        return result.toString();
    }
}
