package zinjvi.leatcode;

import org.junit.Assert;

public class _188_BestTimeToBuyAndSellStockIV {

    public static int maxProfit(int k, int[] prices) {
        if(prices.length == 0) {
            return 0;
        }

        if(k * 2 >= prices.length) {
            int maxProfit = 0;
            for(int i = 1; i < prices.length; i++) {
                if(prices[i-1] < prices[i]) {
                    maxProfit += prices[i] - prices[i-1];
                }
            }
            return maxProfit;
        }

        int transactions = k + 1;

        int[][] profit = new int[transactions][prices.length];
        for (int i = 1; i < transactions; i++) {
            profit[i][0] = 0;
            for (int j = 1; j < prices.length; j++) {
                int previousDayProfit = profit[i][j - 1];
                int todaySellProfit = 0;
                for (int b = 0; b < j; b++) {
                    todaySellProfit = Math.max(
                            todaySellProfit,
                            // Sell it by today's price if I bought it in previous days.
                            // Which previous day I don't know yet, I will choose by max profit.
                            // + profit from the previous transaction fro the day I buy current transaction
                            prices[j] - prices[b] + profit[i - 1][b]
                    );
                }
                profit[i][j] = Math.max(previousDayProfit, todaySellProfit);
            }
        }

        return profit[transactions-1][prices.length - 1];
    }

    public static void main(String[] args) {
        Assert.assertEquals(2, maxProfit(2, new int[]{2, 4, 1}));
        Assert.assertEquals(7, maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));

        Assert.assertEquals(0, maxProfit(0, new int[]{3, 2, 6, 5, 0, 3}));
        Assert.assertEquals(0, maxProfit(2, new int[]{4, 3, 2, 1}));
        Assert.assertEquals(0, maxProfit(2, new int[]{}));
        Assert.assertEquals(0, maxProfit(2, new int[]{1}));

        Assert.assertEquals(4, maxProfit(10, new int[]{2, 4, 1, 3}));
    }

}
