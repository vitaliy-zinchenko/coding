package zinjvi.leatcode;

import zinjvi.Utils;

public class _123_BestTimeToBuyAndSellStockIII {

    public static int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;

        int firstMinBuyPrice = prices[0];
        int firstMaxProfit = 0;
        int secondLocalMax = -prices[0];
        int secondMaxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int priceToday = prices[i];
            int priceYesterday = prices[i-1];
            secondLocalMax = Math.max(secondLocalMax, firstMaxProfit - priceYesterday);
            secondMaxProfit = Math.max(secondMaxProfit, priceToday + secondLocalMax);
            firstMinBuyPrice = Math.min(firstMinBuyPrice, priceToday);
            firstMaxProfit = Math.max(firstMaxProfit, priceToday - firstMinBuyPrice);
        }
        return secondMaxProfit;
    }

    public static void main(String[] args) {
        Utils.assertTrue(7 == maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        Utils.assertTrue(99 == maxProfit(new int[]{5, 1, 10, 100}));

        Utils.assertTrue(0 == maxProfit(new int[]{}));
        Utils.assertTrue(0 == maxProfit(new int[]{1}));
    }
}
