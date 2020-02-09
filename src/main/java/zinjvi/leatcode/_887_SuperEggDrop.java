package zinjvi.leatcode;

import org.junit.Assert;

public class _887_SuperEggDrop {
    public static int superEggDrop(int totalEggs, int stairs) {
        if(totalEggs == 0 || stairs == 0) {
            return 0;
        }

        int totalEggsItems = totalEggs + 1;
        int stairsItems = stairs + 1;
        int[][] cache = new int[totalEggsItems][stairsItems];

        for(int i = 0; i < stairsItems; i++){
            cache[1][i] = i;
        }

        for (int e = 2; e < totalEggsItems; e++) {
            for (int n = 1; n < stairsItems; n++) {
                int bestDropsCount = Integer.MAX_VALUE;
                for (int x = 1; x <= n; x++) {
                    int notBreakDrops = cache[e][n-x];
                    int breakDrops = cache[e-1][x-1];
                    bestDropsCount = Math.min(bestDropsCount, Math.max(notBreakDrops, breakDrops) + 1);
                }
                cache[e][n] = bestDropsCount;
            }
        }

        return cache[totalEggs][stairs];
    }

    public static void main(String[] args) {
        Assert.assertEquals(2, superEggDrop(2, 2));
        Assert.assertEquals(3, superEggDrop(2, 6));
        Assert.assertEquals(4, superEggDrop(3, 14));

        Assert.assertEquals(0, superEggDrop(0, 0));
        Assert.assertEquals(0, superEggDrop(0, 3));
        Assert.assertEquals(0, superEggDrop(3, 0));

        Assert.assertEquals(1, superEggDrop(1, 1));
        Assert.assertEquals(1, superEggDrop(3, 1));

        Assert.assertEquals(13, superEggDrop(10, 5000));
    }
}
