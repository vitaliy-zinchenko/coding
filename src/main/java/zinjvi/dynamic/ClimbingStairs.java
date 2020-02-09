package zinjvi.dynamic;

import org.junit.Assert;

// LeetCode: 70. Climbing Stairs
public class ClimbingStairs {

    public static int climbStairs(int n) {
        int[] a = new int[n + 1];
        a[0] = 1;

        for (int i = 1; i < a.length; i++) {
            // I can come to the i'th stair only from:
            //  - previous stair or
            //  - two stairs back
            // the number of ways to the i'th star would be
            // the sum of numbers from previous and two
            // starts back ways
            int oneStep = a[i - 1];
            int twoSteps = i - 2 < 0 ? 0 : a[i - 2];
            a[i] = oneStep + twoSteps;
        }

        return a[n];
    }

    public static void main(String[] args) {
        Assert.assertEquals(1, climbStairs(0));
        Assert.assertEquals(1, climbStairs(1));
        Assert.assertEquals(2, climbStairs(2));
        Assert.assertEquals(3, climbStairs(3));
    }
}
