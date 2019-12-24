package com.package1;

public class LC123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int K = 2;
        int[][] f = new int[K+1][prices.length];
        int maxP = 0;
        //f[k][i] means: the max profit at i day with k transactions
        //f[k][i] = max(f[k][i-1], max(f[k-1][j] + p[i]-p[j]) (0 <= j <= i-1)
        //        = max(f[k][i-1], p[i] + max(f[k-1][j] - p[j]) (0 <= j <= i-1)

        for (int k = 1; k <= K; k++) {
            int tmpMax = f[k-1][0] - prices[0];
            for (int i = 1; i < prices.length; i++) {
                f[k][i] = Math.max(f[k][i-1],prices[i] + tmpMax);
                tmpMax = Math.max(tmpMax, f[k-1][i] - prices[i]);
                maxP = Math.max(maxP,f[k][i]);
            }
        }
        return maxP;
    }
}
