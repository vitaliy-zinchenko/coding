package zinjvi.dynamic;


import org.junit.Assert;

// TODO finish

// 639. Decode Ways II
// https://leetcode.com/problems/decode-ways-ii/
public class DecodeWaysII {
    public static int numDecodings(String s) {
        int[] cache = new int[s.length() + 1];
        cache[0] = 1;

        for (int i = 1; i < cache.length; i++) {
            int cur = 0;

            // Single digit char
            if(s.charAt(i-1) == '*') {
                cur += 9;
            } else if (s.charAt(i-1) != '0') {
                cur += cache[i-1];
            }

            // Double digit char
            if(i >= 2) {
                String digit = s.substring(i-2, i);
                if(digit.contains("*")) {
                    int wildcardCount = 0;
                    if(digit.equals("**")) {
                        wildcardCount = 17;
                    } else {
                        for (int j = 1; j <= 9; j++) {
                            int twoDigNum = Integer.parseInt(digit.replace("*", Integer.toString(j)));
                            if(twoDigNum >= 10 && twoDigNum <= 26) {
                                wildcardCount++;
                            }
                        }
                    }
                    cur += cache[i-2] * wildcardCount;
                } else {
                    int twoDigNum = Integer.parseInt(digit);
                    if(twoDigNum >= 10 && twoDigNum <= 26) {
                        cur += cache[i-2];
                    }
                }
            }

            cache[i] = cur;
        }

        return cache[cache.length-1];
    }

    public static void main(String[] args) {
        Assert.assertEquals(9, numDecodings("*"));
        Assert.assertEquals(18, numDecodings("1*"));
//        Assert.assertEquals(30, numDecodings("1*2"));
        Assert.assertEquals(9, numDecodings("3*"));
        Assert.assertEquals(10, numDecodings("*7"));
        Assert.assertEquals(9, numDecodings("0*"));
        Assert.assertEquals(2, numDecodings("*0"));
//        Assert.assertEquals(81, numDecodings("**"));

        Assert.assertEquals(1, numDecodings(""));
    }
}
