package zinjvi.leatcode;

import java.util.HashMap;
import java.util.Map;

//class Solution {
public class _3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Integer start = 0;
        Integer max = 0;

        Map<Character, Integer> win = new HashMap<>();

        for(int curr = 0; curr < s.length(); curr++) {
            Character c = s.charAt(curr);
            if(win.containsKey(c)) {
                start = Math.max(start, win.get(c) + 1);
            }
            win.put(c, curr);
            max = Math.max(max, curr - start + 1);
        }
        return max;
    }
}