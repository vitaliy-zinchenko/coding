package zinjvi.leatcode;

public class _9_PalindromeNumber {
    //    class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        return isPalindromeUtil(x, x) != -1;
    }

    private int isPalindromeUtil(int left, int right) {
        if (left <= 0)
            return right;
        else
            right = isPalindromeUtil(left / 10, right);

        if (left % 10 == right % 10)
            return right / 10;
        else
            return -1;
    }
}