package zinjvi.arrays_strings;


import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

// Solution options:
// With additional data structure:
//  - have a boolean[]/BitSet to store the char occurrences
//  - have a int/long and perform bit manipulations
//      limitations: supports up to 4/8 character encoding
// Without additional data structure - m = O(1):
//  - run loop inside loop: t = O(n^2)
//  - if input can be modified, perform in place sort and
//    then scan the result to find two the same chars
public class IsUnique {

    public static boolean isUnique(String s) {
        // Assume that the input is encoded in ASCII
        int maxCharEncodingsSize = (int) Math.pow(2, 7);

        // the input has more chars then chars in en encoding,
        // which is impossible for unique char string
        if(s.length() > maxCharEncodingsSize) {
            return false;
        }

        boolean[] checker = new boolean[maxCharEncodingsSize];

        for(int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (checker[curChar]) {
                return false;
            } else {
                checker[curChar] = true;
            }
        }

        return true;
    }

    public static boolean isUniqueBitManipulations(String s) {
        // FINISH
        return false;
    }

    public static void main(String[] args) {
        Assert.assertEquals(true, isUnique("qwer"));
        Assert.assertEquals(false, isUnique("qwerwg"));
        Assert.assertEquals(true, isUnique(""));
        Assert.assertEquals(false, isUnique(StringUtils.repeat("a", 128)));

        Assert.assertEquals(true, isUniqueBitManipulations("qwer"));
        Assert.assertEquals(false, isUniqueBitManipulations("qwerwg"));
        Assert.assertEquals(true, isUniqueBitManipulations(""));
        Assert.assertEquals(false, isUniqueBitManipulations(StringUtils.repeat("a", 128)));
    }

}
