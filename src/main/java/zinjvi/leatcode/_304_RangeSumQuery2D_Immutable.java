package zinjvi.leatcode;

import org.junit.Assert;

class NumMatrix {

    int[][] cache;

    public NumMatrix(int[][] matrix) {
        cache = new int[matrix.length][matrix.length == 0 ? 0 : matrix[0].length + 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                cache[i][j + 1] = matrix[i][j] + cache[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int response = 0;
        for(int i = row1; i <= row2; i++) {
            response += cache[i][col2+1] - cache[i][col1];
        }
        return response;
    }
}

public class _304_RangeSumQuery2D_Immutable {
    public static void main(String[] args) {

        NumMatrix num = new NumMatrix(new int[][]{
                new int[]{3, 0, 1, 4, 2},
                new int[]{5, 6, 3, 2, 1},
                new int[]{1, 2, 0, 1, 5},
                new int[]{4, 1, 0, 1, 7},
                new int[]{1, 0, 3, 0, 5}
        });

        Assert.assertEquals(8, num.sumRegion(2, 1, 4, 3));
        Assert.assertEquals(11, num.sumRegion(1, 1, 2, 2));
        Assert.assertEquals(12, num.sumRegion(1, 2, 2, 4));
    }
}
