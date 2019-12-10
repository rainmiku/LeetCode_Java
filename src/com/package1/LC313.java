package com.package1;

public class LC313 {
    public int nthSuperUglyNumber(int n, int[] primes) {

        int[] ugly = new int[n];
        int[] index = new int [primes.length];

        ugly[0] = 1;

        for (int i = 1; i < n; i++) {
            int min = primes[0] * ugly[index[0]];
            int minIndex = 0;
            for (int j = 1; j < primes.length; j++) {
                if (min > primes[j] * ugly[index[j]]){
                    min = primes[j] * ugly[index[j]];
                    minIndex = j;
                }else if (min == primes[j] * ugly[index[j]])
                    index[j]++;
            }
            ugly[i] = min;
            index[minIndex]++;
        }
        return ugly[n-1];
    }


}
