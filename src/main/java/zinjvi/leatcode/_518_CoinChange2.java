package zinjvi.leatcode;

import org.junit.Assert;

public class _518_CoinChange2 {
    public static int change(int amount, int[] coins) {
        int[] prev = new int[amount + 1];
        int[] cur = new int[amount + 1];
        prev[0] = cur[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            prev = cur;
            for (int j = 1; j < cur.length; j++) {
                int coin = coins[i];
                int notIncludingCoin = prev[j];
                int includingCoin = 0;
                if (coin <= j) {
                    includingCoin = cur[j-coin];
                }
                cur[j] = includingCoin + notIncludingCoin;
            }
        }

        return cur[amount];
    }

    public static void main(String[] args) {
        Assert.assertEquals(4, change(5, new int[]{1, 2, 5}));

        Assert.assertEquals(1, change(0, new int[]{1, 2, 5}));
        Assert.assertEquals(0, change(5, new int[]{}));
    }
}
