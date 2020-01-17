package zinjvi.leatcode;

import zinjvi.Utils;

import java.util.Arrays;

public class _300_LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;

        int[] a = new int[nums.length];
        Arrays.fill(a, 1);

        for (int r = 1; r < nums.length; r++) {
            for (int l = 0; l < r; l++) {
                if (nums[l] < nums[r] && a[l] + 1 > a[r]) {
                    a[r] = a[l] + 1;
                }
            }
        }

        int maxLen = 1;
        for (int i = 0; i < a.length; i++) {
            maxLen = Math.max(a[i], maxLen);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Utils.assertTrue(4 == lengthOfLIS(new int[]{3, 4, -1, 0, 6, 2, 3}));
        Utils.assertTrue(6 == lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));

        Utils.assertTrue(1 == lengthOfLIS(new int[]{2, 2}));

        Utils.assertTrue(0 == lengthOfLIS(new int[]{}));
        Utils.assertTrue(1 == lengthOfLIS(new int[]{3}));

        System.out.println("end");
    }

}
