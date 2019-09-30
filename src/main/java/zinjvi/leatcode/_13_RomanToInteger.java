package zinjvi.leatcode;

import java.util.HashMap;
import java.util.Map;

public class _13_RomanToInteger {
    //    class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int start = 0;
        int end = 0;
        int num = 0;

        while (end < s.length()) {
            if (end + 1 < s.length() && map.get(s.charAt(end)) < map.get(s.charAt(end + 1))) {
                end++;
            } else {
                int e = end;
                int subNum = map.get(s.charAt(e--));
                while (start <= e) {
                    subNum -= map.get(s.charAt(e--));
                }
                end++;
                start = end;
                num += subNum;
            }
        }
        return num;
    }
}