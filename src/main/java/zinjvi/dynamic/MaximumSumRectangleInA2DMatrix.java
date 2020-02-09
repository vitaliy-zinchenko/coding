package zinjvi.dynamic;

import org.junit.Assert;

//Question: Given a 2D matrix with integer values
// (and including at least 1 positive value) find
// the sub-rectangle with the largest sum.

// https://www.youtube.com/watch?v=-FgseNO-6Gk&list=PLiQ766zSC5jM2OKVr8sooOuGgZkvnOCTI&index=5
// https://www.youtube.com/watch?v=yCQN096CwWM
public class MaximumSumRectangleInA2DMatrix {

    public static int max(int[][] a) {
        if (a.length == 0) {
            return 0;
        }

        int raws = a.length;
        int colums = a[0].length;

        int max = Integer.MIN_VALUE;
        int[] sums = new int[colums];

        for (int r1 = 0; r1 < raws; r1++) {
            for (int c = 0; c < colums; c++) {
                sums[c] = 0;
            }
            for (int r2 = r1; r2 < raws; r2++) {
                int curMax = Integer.MIN_VALUE;
                int previousSum = 0;
                for (int c = 0; c < colums; c++) {
                    sums[c] += a[r2][c];
                    previousSum = Math.max(previousSum + sums[c], sums[c]);
                    curMax = Math.max(curMax, previousSum);
                }
                max = Math.max(max, curMax);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Assert.assertEquals(18, max(
                new int[][]{
                        {2, 1, -3, -4, 5},
                        {0, 6, 3, 4, 1},
                        {2, -2, -1, 4, -5},
                        {-3, 3, 1, 0, 3}
                }
        ));

        Assert.assertEquals(2, max(
                new int[][]{
                        {2}
                }
        ));

        Assert.assertEquals(-2, max(
                new int[][]{
                        {-2}
                }
        ));
    }
}
