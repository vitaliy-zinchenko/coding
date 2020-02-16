package zinjvi.dynamic;

import org.junit.Assert;

// 31. Next Permutation
// https://leetcode.com/problems/next-permutation/
// https://youtu.be/PYXl_yY-rms?t=130
// https://www.youtube.com/watch?v=quAS1iydq7U&list=PLiQ766zSC5jM2OKVr8sooOuGgZkvnOCTI&index=11
public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;

        int pivotIndex = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                pivotIndex = nums[i - 1];
            }
        }

        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i < nums.length; i++) {
            if (nums[i] > nums[pivotIndex]) {
                swapIndex = nums[i] < nums[swapIndex] ? i : swapIndex;
            }
        }

        swap(nums, pivotIndex, swapIndex);

        int revertStartIndex = pivotIndex + 1;
        for (int i = revertStartIndex; i <= (nums.length - 1 + revertStartIndex) / 2; i++) {
            swap(nums, i, nums.length - 1 - (i - revertStartIndex));
        }
    }

    private static void swap(int[] a, int from, int to) {
        int temp = a[to];
        a[to] = a[from];
        a[from] = temp;
    }

    public static void main(String[] args) {
        check(new int[]{1, 2, 3}, new int[]{1, 3, 2});
        check(new int[]{3, 2, 1}, new int[]{1, 2, 3});
        check(new int[]{1, 1, 5}, new int[]{1, 5, 1});

        check(new int[]{6, 2, 1, 5, 4, 3, 0}, new int[]{6, 2, 3, 0, 1, 4, 5});

        check(new int[]{}, new int[]{});
        check(new int[]{1}, new int[]{1});
        check(new int[]{1, 2}, new int[]{2, 1});
    }

    public static void check(int[] perm, int[] next) {
        nextPermutation(perm);
        Assert.assertArrayEquals(next, perm);
    }

}
