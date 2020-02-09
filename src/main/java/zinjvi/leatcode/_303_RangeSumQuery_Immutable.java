package zinjvi.leatcode;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//class NumArraySimple {
//
//    private int[][] cache;
//
//    public NumArraySimple(int[] nums) {
//        cache = new int[nums.length][nums.length];
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i; j < nums.length; j++) {
//                if (i == j) {
//                    cache[i][j] = nums[i];
//                } else {
//                    cache[i][j] = nums[j] + cache[i][j - 1];
//                }
//            }
//        }
//    }
//
//    public int sumRange(int i, int j) {
//        if (i > j) {
//            throw new IllegalArgumentException();
//        }
//        return cache[i][j];
//    }
//}
//
//class NumArrayMap {
//
//    class Node {
//        int i, j;
//
//        public Node(int i, int j) {
//            this.i = i;
//            this.j = j;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Node node = (Node) o;
//            return i == node.i &&
//                    j == node.j;
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(i, j);
//        }
//    }
//
//    private Map<Node, Integer> cache = new HashMap<>();
//
//    public NumArrayMap(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i; j < nums.length; j++) {
//                if (i == j) {
//                    cache.put(new Node(i, j), nums[i]);
//                } else {
//                    cache.put(new Node(i, j), nums[j] + cache.get(new Node(i, j-1)));
//                }
//            }
//        }
//    }
//
//    public int sumRange(int i, int j) {
//        if (i > j) {
//            throw new IllegalArgumentException();
//        }
//        return cache.get(new Node(i, j));
//    }
//}
//
//class NumArrayMapLazy {
//
//    class Node {
//        int i, j;
//
//        public Node(int i, int j) {
//            this.i = i;
//            this.j = j;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Node node = (Node) o;
//            return i == node.i &&
//                    j == node.j;
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(i, j);
//        }
//    }
//
//    private Map<Node, Integer> cache = new HashMap<>();
//
//    private int[] nums;
//
//    public NumArrayMapLazy(int[] nums) {
//        this.nums = nums;
//    }
//
//    public int sumRange(int i, int j) {
//        if (i > j) {
//            throw new IllegalArgumentException();
//        }
//        int result;
//        if(i == j) {
//            result = nums[i];
//        } else {
//            result = sumRange(i, j-1) + nums[j];
//        }
//        cache.put(new Node(i, j), result);
//        return result;
//    }
//}

class NumArray {

    private int[] cache;

    public NumArray(int[] nums) {
        cache = new int[nums.length + 1];

        for (int i = 0; i < cache.length - 1; i++) {
            cache[i + 1] = cache[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i < 0 || j < 0 || i > j || i > cache.length || j > cache.length) {
            throw new IllegalArgumentException();
        }

        return cache[j+1] - cache[i];
    }
}

public class _303_RangeSumQuery_Immutable {
    public static void main(String[] args) {
        NumArray nums = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});

        Assert.assertEquals(1, nums.sumRange(0, 2));
        Assert.assertEquals(-1, nums.sumRange(2, 5));
        Assert.assertEquals(-3, nums.sumRange(0, 5));
    }
}
