package zinjvi.leatcode;

import zinjvi.Utils;

public class _121_BestTimeToBuyandSellStock {

    // Time: O(n)
    // Space: O(1)
    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(
                    // Profit of the best transaction before today
                    maxProfit,
                    // Profit if I buy for the best price and sell current day
                    prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }

    // Time: O(n)
    // Space: O(1)
    public static int maxProfit2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(
                    // Profit of the best transaction before today
                    maxProfit,
                    // Profit if I buy for the best price and sell current day
                    prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }

    // Time: O(n)
    // Space: O(n)
    public static int maxProfit1(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int[] max = new int[prices.length]; // [7, 6, 6, 6, 6, 4] // [7, 5, 3, 1]
        max[prices.length - 1] = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            max[i] = Math.max(prices[i], max[i + 1]);
        }

        int maxProfit = 0; // 5
        for (int i = 0; i < prices.length - 1; i++) {
            maxProfit = Math.max(maxProfit, max[i + 1] - prices[i]);
        }

        return maxProfit;
    }


    public static void main(String[] args) {
        Utils.assertTrue(5 == maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        Utils.assertTrue(1 == maxProfit(new int[]{1, 2}));

        Utils.assertTrue(0 == maxProfit(new int[]{7, 5, 3, 1}));
        Utils.assertTrue(0 == maxProfit(new int[]{7}));
        Utils.assertTrue(0 == maxProfit(new int[]{}));

        Utils.assertTrue(5 == maxProfit1(new int[]{7, 1, 5, 3, 6, 4}));
        Utils.assertTrue(1 == maxProfit1(new int[]{1, 2}));

        Utils.assertTrue(0 == maxProfit1(new int[]{7, 5, 3, 1}));
        Utils.assertTrue(0 == maxProfit1(new int[]{7}));
        Utils.assertTrue(0 == maxProfit1(new int[]{}));
    }

}
