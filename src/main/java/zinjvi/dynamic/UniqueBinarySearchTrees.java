package zinjvi.dynamic;

import org.junit.Assert;

import java.util.Arrays;

// LeetCode: 96. Unique Binary Search Trees
// https://www.youtube.com/watch?v=GgP75HAvrlY&list=PLiQ766zSC5jM2OKVr8sooOuGgZkvnOCTI&index=10
public class UniqueBinarySearchTrees {

    public static int numTrees(int n) {
        int[] a = new int[n+1];
        a[0] = 1;

        if (n > 0) {
            a[1] = 1;
        }

        for(int i = 2; i < a.length; i++) {
            for(int j = 1; j <= i; j++) {
                a[i] += a[j-1] * a[i-j];
            }
        }
        return a[n];
    }

    public static void main(String[] args) {
        Assert.assertEquals(5, numTrees(3));
        Assert.assertEquals(2, numTrees(2));
        Assert.assertEquals(1, numTrees(1));
        Assert.assertEquals(1, numTrees(0));
    }

}
