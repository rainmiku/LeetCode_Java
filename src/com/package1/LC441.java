package com.package1;

public class LC441 {
    public int arrangeCoins(int n) {
        return (int)((-1+Math.sqrt(1+8*(double)n))/2);
    }
}
