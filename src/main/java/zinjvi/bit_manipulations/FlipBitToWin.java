package zinjvi.bit_manipulations;

import org.junit.Assert;

public class FlipBitToWin {

    public static int flip(int n) {
        int[] a = toArray(n);

        int max = 0;
        boolean isOne = true;
        int prevOneLen = 0;

        for(int i = 1; i < a.length && a[i] > 0; i++) {
            if(isOne) {
                // If previous (Zero Length) more then 1 (multiple zeros) then use only single flip
                // Otherwise, add flip and previous ones len.
                //   this should work fine on the beginning and inside the array.
                int prevOneLenAndFlip = a[i-1] > 1 ? 1 : a[i] + 1 + prevOneLen;
                max = Math.max(max, prevOneLenAndFlip);

                prevOneLen = a[i];
            }
            isOne = !isOne;
        }

        return max;
    }

    /**
     * Returns the array of zeros and ones counts.
     * Always starts from zero count, event if there is no zero at first position
     * in this case the count is 0.
     */
    private static int[] toArray(int n) {
        int[] a = new int[33];
        int aIndex = 0;
        boolean isPrevOne = false;

        int singleOneAtRight = 1;

        for (int i = 0; i < 32; i++) {
            boolean isOne = (n & singleOneAtRight) == 1;

            if(isOne != isPrevOne) {
                aIndex++;
            }
            a[aIndex]++;

            n = n >>> 1;
            isPrevOne = isOne;
        }

        return a;
    }

    public static void main(String[] args) {
        Assert.assertEquals(8, flip(Integer.parseInt("11011101111", 2)));
        Assert.assertEquals(8, flip(Integer.parseInt("110111011110011111", 2)));
        Assert.assertEquals(3, flip(Integer.parseInt("1010101010101010101010101010101", 2)));
    }
}
