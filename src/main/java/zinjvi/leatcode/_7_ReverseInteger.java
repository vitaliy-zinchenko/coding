package zinjvi.leatcode;

public class _7_ReverseInteger {
    //    class Solution {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        int currX = sign * x;
        int num = 0;
        while (currX > 0) {
            int digit = currX % 10;
            currX = currX / 10;
            if (sign > 0 && sign * num > Integer.MAX_VALUE / 10 ||
                    sign < 0 && sign * num < Integer.MIN_VALUE / 10 ||
                    sign > 0 && sign * num * 10 > Integer.MAX_VALUE - digit ||
                    sign < 0 && sign * num * 10 < Integer.MIN_VALUE + digit) {
                return 0;
            } else {
                num = num * 10 + digit;
            }
        }
        return sign * num;
    }

}