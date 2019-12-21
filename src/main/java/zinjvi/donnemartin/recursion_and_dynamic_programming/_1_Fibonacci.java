package zinjvi.donnemartin.recursion_and_dynamic_programming;

public class _1_Fibonacci {

    // n      = 0 1 2 3 4 5 6 7  8
    // result = 0 1 1 2 3 5 8 13 21


    // Complexity: O(n)
    public int iterative(int n) {
        int curr = 0;
        int next = 1;

        for (int i = 0; i < n; i++) {
            curr = next;
            next = curr + next;
        }
        return curr;
    }

    // O(2^n)
    public int recursive(int n) {
        if(n <= 1) {
            return n;
        } else {
            return recursive(n - 2) + recursive(n - 1);
        }
    }

    // O(n)
    public int dynamic(int n) {
        int[] cache = new int[n];
        return resursiveDynamic(n, cache);
    }

    private int resursiveDynamic(int n, int[] cache) {
        if(n <= 1) {
            return n;
        } else if(cache[n] != 0) {
             return cache[n];
        } else {
            cache[n] = resursiveDynamic(n - 2, cache) + resursiveDynamic(n -1, cache);
            return cache[n];
        }
    }

    public static void main(String[] args) {
        assert new _1_Fibonacci().iterative(0) == 0;
        assert new _1_Fibonacci().iterative(1) == 1;
        assert new _1_Fibonacci().iterative(1) == 1;
        assert new _1_Fibonacci().iterative(2) == 1;
        assert new _1_Fibonacci().iterative(3) == 2;
        assert new _1_Fibonacci().iterative(8) == 21;

        assert new _1_Fibonacci().recursive(0) == 0;
        assert new _1_Fibonacci().recursive(1) == 1;
        assert new _1_Fibonacci().recursive(1) == 1;
        assert new _1_Fibonacci().recursive(2) == 1;
        assert new _1_Fibonacci().recursive(3) == 2;
        assert new _1_Fibonacci().recursive(8) == 21;

        assert new _1_Fibonacci().dynamic(0) == 0;
        assert new _1_Fibonacci().dynamic(1) == 1;
        assert new _1_Fibonacci().dynamic(1) == 1;
        assert new _1_Fibonacci().dynamic(2) == 1;
        assert new _1_Fibonacci().dynamic(3) == 2;
        assert new _1_Fibonacci().dynamic(8) == 21;

        System.out.println("end");
    }
}
