package zinjvi.bit_manipulations;

import org.junit.Assert;

public class Insertion {
    //                     j|6 i|2
    // N =              10001001100
    // M =                    10011

    // zerosInRange =   11110000011
    // shiftedM =           1001100
    // clearedN =       10000000000
    // result =         10001001100

    public static int insert(int n, int m, int i, int j) {
        int allOnes = ~0;
        int onesInRange = (allOnes >>> 32 - (j-i)) << i;
        int zerosInRange = ~onesInRange;
        int shiftedM = m << i;
        int clearedN = n & zerosInRange;
        return clearedN | shiftedM;
    }

    public static void main(String[] args) {
        Assert.assertEquals(
                "10001001100",
                Integer.toBinaryString(insert(
                        Integer.parseInt("10000000000", 2),
                        Integer.parseInt("10011", 2),
                        2,
                        6)));
    }
}
