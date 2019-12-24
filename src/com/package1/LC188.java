package com.package1;

public class LC188 {

    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[]f = new int[prices.length];

        //when k is larger than all days / 2, it is same to you can do the transactions what times you want.(without this will TLE
        if (k >=  prices.length/2) {
            int maxPro = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i-1])
                    maxPro += prices[i] - prices[i-1];
            }
            return maxPro;
        }

        //f[k][i] means: the max profit at i day with k transactions
        //f[k][i] = max(f[k][i-1], max(f[k-1][j] + p[i]-p[j]) (0 <= j <= i-1)
        //        = max(f[k][i-1], p[i] + max(f[k-1][j] - p[j]) (0 <= j <= i-1)
        for (int K = 1; K <= k; K++) {
            int tmpMax = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                int last = f[i];     //last = f[k-1][i]; the last cycle at position i.
                f[i] = Math.max(f[i-1],prices[i] + tmpMax);
                tmpMax = Math.max(tmpMax, last - prices[i]);
            }
        }
        return f[prices.length-1];
    }

}
