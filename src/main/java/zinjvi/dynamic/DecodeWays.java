package zinjvi.dynamic;


import org.junit.Assert;

// 91. Decode Ways
// https://leetcode.com/problems/decode-ways/
// https://www.youtube.com/watch?v=YcJTyrG3bZs&list=PLiQ766zSC5jM2OKVr8sooOuGgZkvnOCTI&index=13
public class DecodeWays {

    public static int numDecodings(String s) {
        int[] cache = new int[s.length() + 1];
        cache[0] = 1;

        for (int i = 1; i < cache.length; i++) {
            int currentNum = 0;

            // Decoding one digit char
            if(Integer.parseInt(s.substring(i - 1, i)) > 0) {
                currentNum += cache[i - 1];
            }

            // Decoding two digits
            if (i - 2 >= 0) {
                int twoDigNumber = Integer.parseInt(s.substring(i - 2, i));
                if (twoDigNumber >= 10 && twoDigNumber < 27) {
                    currentNum += cache[i-2];
                }
            }

            cache[i] = currentNum;
        }

        return cache[cache.length - 1];
    }


    public static void main(String[] args) {
        Assert.assertEquals(2, numDecodings("12"));
        Assert.assertEquals(3, numDecodings("226"));
        Assert.assertEquals(1, numDecodings("2"));
        Assert.assertEquals(1, numDecodings("276"));
        Assert.assertEquals(2, numDecodings("227"));
        Assert.assertEquals(0, numDecodings("0"));
        Assert.assertEquals(0, numDecodings("00"));
        Assert.assertEquals(0, numDecodings("01"));
        Assert.assertEquals(1, numDecodings("10"));

        Assert.assertEquals(1, numDecodings(""));
    }
}
