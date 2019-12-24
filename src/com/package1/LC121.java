package com.package1;

public class LC121 {
    public int maxProfit(int[] prices) {

        int minBuy = Integer.MAX_VALUE;
        int maxSell = Integer.MIN_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > maxSell)
                maxSell = prices[i];
            if (prices[i] < minBuy){
                minBuy = prices[i];
                maxSell = minBuy;
            }

            int profit = maxSell - minBuy;
            if (profit > maxProfit)
                maxProfit = profit;
        }
        return maxProfit;
    }
}
