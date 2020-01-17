package zinjvi.leatcode;

import zinjvi.Utils;

public class _122_BestTimeToBuyAndSellStockII {
    // Time: O(n)
    // Space: O(1)
    public static int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        int profit = 0;
        for(int i = 0; i < prices.length - 1; i++) {
            if(prices[i] < prices[i+1]) {
                profit += prices[i+1] - prices[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        Utils.assertTrue(7 == maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        Utils.assertTrue(99 == maxProfit(new int[]{5, 1, 10, 100}));

        Utils.assertTrue(0 == maxProfit(new int[]{}));
        Utils.assertTrue(0 == maxProfit(new int[]{1}));
    }
}
