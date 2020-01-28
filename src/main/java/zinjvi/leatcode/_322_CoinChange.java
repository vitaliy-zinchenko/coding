package zinjvi.leatcode;

import org.junit.Assert;

public class _322_CoinChange {

    public static int coinChange(int[] coins, int amount) {
        if(coins.length == 0) {
            return -1;
        }

        int[] counts = new int[amount + 1];

        counts[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int minCount = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                if (i - coin >= 0 && counts[i - coin] != Integer.MAX_VALUE) {
                    minCount = Math.min(minCount, counts[i - coin] + 1);
                }
            }
            counts[i] = minCount;
        }

        return counts[amount] == Integer.MAX_VALUE ? -1 : counts[amount];
    }

    public static void main(String[] args) {
        Assert.assertEquals(3, coinChange(new int[]{1, 2, 5}, 9));

        Assert.assertEquals(0, coinChange(new int[]{1, 2, 5}, 0));
        Assert.assertEquals(-1, coinChange(new int[]{}, 9));
        Assert.assertEquals(-1, coinChange(new int[]{5}, 4));

        Assert.assertEquals(-1, coinChange(new int[]{2}, 3));

        Assert.assertEquals(0, coinChange(new int[]{1}, 0));
    }

}
