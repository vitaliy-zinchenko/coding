package zinjvi.leatcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _12_IntegerToRoman {
    //    class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        Stack<String> st = new Stack<>();
        int pow = 1;

        while (num > 0) {
            int curr = num % (int) Math.pow(10, pow);
            num -= curr;
            int delta = (int) Math.pow(10, pow - 1);
            pow++;

            if (curr <= 0) continue;

            while (!map.containsKey(curr)) {
                st.push(map.get(delta));
                curr -= delta;
            }
            st.push(map.get(curr));
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) sb.append(st.pop());

        return sb.toString();
    }
}