package zinjvi.bit_manipulations;

import org.junit.Assert;

public class BinaryToString {

    public static String convert(double d) {
        StringBuilder s = new StringBuilder();
        s.append(".");

        while (d != 0) {
            if (s.length() > 33) {
                return "ERROR";
            }

            d = d * 2;

            if (d >= 1) {
                s.append("1");
                d = d - 1;
            } else {
                s.append("0");
            }
        }

        return s.toString();
    }

    public static void main(String[] args) {
        Assert.assertEquals("ERROR", convert(0.72));
        Assert.assertEquals("ERROR", convert(0.3));
        Assert.assertEquals(".101", convert(0.625));
        Assert.assertEquals(".", convert(0.0));
    }

}
