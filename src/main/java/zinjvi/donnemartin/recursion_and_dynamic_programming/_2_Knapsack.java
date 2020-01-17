package zinjvi.donnemartin.recursion_and_dynamic_programming;

import zinjvi.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class _2_Knapsack {

    private static class Item {
        private int tw;
        private int left;

        public Item(int tw, int left) {
            this.tw = tw;
            this.left = left;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Item item = (Item) o;
            return tw == item.tw &&
                    left == item.left;
        }

        @Override
        public int hashCode() {
            return Objects.hash(tw, left);
        }
    }

    public int count = 0;

    public int fill(int[] w, int[] v, int tw) {
        Map<Item, Integer> memo = new HashMap<>();
        return fill(memo, w, v, tw, w.length);
    }

    public int fill(Map<Item, Integer> memo, int[] w, int[] v, int tw, int left) {
        count++;
        System.out.println(tw + " - " + left);

        int i = w.length - left;
        Item memoKey = new Item(tw, left);

        if (left <= 0 || tw <= 0) {
            return 0;
        } else if (memo.containsKey(memoKey)) {
            System.out.println(":) " + tw + " - " + left);
            return memo.get(memoKey);
        }

        int result = 0;

        if (w[i] > tw) {
            result = fill(memo, w, v, tw, left - 1);
        } else {
            int valueWithCurrent = v[i] + fill(memo, w, v, tw - w[i], left - 1);
            int valueWithoutCurrent = fill(memo, w, v, tw, left - 1);
            result = Math.max(valueWithCurrent, valueWithoutCurrent);
        }

        memo.put(memoKey, result);

        return result;
    }

    // tw = 8
    // w | 2 2 4 5
    // v | 2 4 6 9
    // >> 13

    // tw = 0
    // >> 0

    // tw = 8
    // w | 0
    // v | 0
    // >> 0

    // tw = 8
    // w | 7
    // v | 0
    // >> 0

    // tw = 8
    // w | 9
    // v | 10
    // >> 0

    // tw = 8
    // w | 0
    // v | 10
    // >> 10
    public static void main(String[] args) {
        int[] w = new int[]{2, 2, 4, 5};
        int[] v = new int[]{2, 4, 6, 9};

        _2_Knapsack k = new _2_Knapsack();
        int result = k.fill(w, v, 8);

        System.out.println("k.count = " + k.count);
        System.out.println("result = " + result);

        Utils.assertTrue(k.fill(w, v, 8) == 13);
        Utils.assertTrue(k.fill(w, v, 0) == 0);
        Utils.assertTrue(k.fill(new int[]{0}, new int[]{0}, 8) == 0);
        Utils.assertTrue(k.fill(new int[]{7}, new int[]{0}, 8) == 0);
        Utils.assertTrue(k.fill(new int[]{9}, new int[]{10}, 8) == 0);
        Utils.assertTrue(k.fill(new int[]{0}, new int[]{10}, 8) == 10);

        System.out.println("end");
    }
}
