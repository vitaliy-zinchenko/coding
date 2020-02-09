package zinjvi.leatcode;


import org.junit.Assert;

public class _1143_LongestCommonSubsequence {

    // t: O(mn)
    // s: O(min(m, n))
    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() > text2.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }

        int[] curCache = new int[text1.length() + 1];
        int[] prevCache = new int[text1.length() + 1];

        for (int i = 0; i < text2.length(); i++) {
            for(int j = 0; j < text1.length(); j++) {
                if(text1.charAt(j) == text2.charAt(i)) {
                    curCache[cacheIndex(j)] = 1 + prevCache[cacheIndex(j-1)];
                } else {
                    curCache[cacheIndex(j)] = Math.max(curCache[cacheIndex(j-1)], prevCache[cacheIndex(j)]);
                }
            }
            int[] temp = prevCache;
            prevCache = curCache;
            curCache = temp;
        }

        return prevCache[prevCache.length-1];
    }

    private static int cacheIndex(int strIndex) {
        return strIndex + 1;
    }

    public static void main(String[] args) {
        Assert.assertEquals(3, longestCommonSubsequence("abcde", "ace"));
        Assert.assertEquals(3, longestCommonSubsequence("abc", "abc"));
        Assert.assertEquals(0, longestCommonSubsequence("abc", "def"));

        Assert.assertEquals(2, longestCommonSubsequence("abc", "cab"));

        Assert.assertEquals(5, longestCommonSubsequence("abcdenkst", "ankste"));
        Assert.assertEquals(1, longestCommonSubsequence("bsb", "jbk"));
        Assert.assertEquals(1, longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
    }
}
