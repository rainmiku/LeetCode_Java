package com.package1;

public class LC096 {
    public int numTrees(int n) {
        return numTrees(1,n);
    }

    private int numTrees(int start, int end){
        if (start >= end)
            return 1;
        int sum = 0;
        for (int i = start; i <=end; i++) {
            int left = numTrees(start,i-1);
            int right = numTrees(i+1,end);
            sum += left*right;
        }
        return sum;
    }
}
