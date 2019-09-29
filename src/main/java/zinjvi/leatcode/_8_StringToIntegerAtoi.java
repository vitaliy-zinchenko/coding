package zinjvi.leatcode;

public class _8_StringToIntegerAtoi {
//class Solution {
    public int myAtoi(String str) {
        int num = 0;
        int sign = 1;
        int curr = 0;
        while(curr < str.length() && str.charAt(curr) == ' ') curr++;
        if(curr < str.length() && (str.charAt(curr) == '-' || str.charAt(curr) == '+')) {
            sign = str.charAt(curr) == '-' ? -1 : 1;
            curr++;
        }
        while(curr < str.length()) {
            char c = str.charAt(curr++);
            if(Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                if (sign > 0 && sign * num > Integer.MAX_VALUE / 10 ||
                        sign < 0 && sign * num < Integer.MIN_VALUE / 10 ||
                        sign > 0 && sign * num * 10 > Integer.MAX_VALUE - digit ||
                        sign < 0 && sign * num * 10 < Integer.MIN_VALUE + digit) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                } else {
                    num = num * 10 + digit;
                }
            } else {
                break;
            }
        }
        return sign * num;
    }
}

