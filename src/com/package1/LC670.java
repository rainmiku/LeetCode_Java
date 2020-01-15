package com.package1;

import java.util.Arrays;

public class LC670 {
    public int maximumSwap(int num) {
        int[] a = new int[10];
        int n = 0;

        while (num != 0)
        {
            a[n++] = num % 10;
            num /=10;
        }

        int[] sorted = Arrays.copyOf(a,n);
        Arrays.sort(sorted);
        
        int k=n-1;
        
        while ( k > 0 && a[k] == sorted[k])
            k--;
        
        if (k>0){
            int maxi = k;
            for (int i = 0; i<n;i++) {
                if (a[i] == sorted[k]){
                    maxi = i;
                    break;
                }
            }
            int t = a[k];
            a[k] = a[maxi];
            a[maxi] = t;
        }

        int result =0;
        for (int i = n-1; i >= 0; i--)
            result = result*10+a[i];

        return result;

    }


}
