package zinjvi.dynamic;


import org.junit.Assert;

import java.util.*;

// 46. Permutations
// https://leetcode.com/problems/permutations/
// https://www.youtube.com/watch?v=GCm7m5671Ps
// https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        perm(new ArrayList<>(), new HashSet<>(), nums, res);
        return res;
    }

    public static void perm(List<Integer> cur, Set<Integer> curSet, int[] nums, List<List<Integer>> res) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
        } else {
            for (int num : nums) {
                if (curSet.contains(num)) continue;
                cur.add(num);
                curSet.add(num);
                perm(cur, curSet, nums, res);
                cur.remove(cur.size() - 1);
                curSet.remove(num);
            }
        }
    }

    public static void main(String[] args) {
        Assert.assertEquals(
                Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(1, 3, 2),
                        Arrays.asList(2, 1, 3),
                        Arrays.asList(2, 3, 1),
                        Arrays.asList(3, 1, 2),
                        Arrays.asList(3, 2, 1)
                ),
                permute(new int[]{1, 2, 3}));
        Assert.assertEquals(
                Arrays.asList(
                        Arrays.asList(1, 2),
                        Arrays.asList(2, 1)
                ),
                permute(new int[]{1, 2}));
        Assert.assertEquals(
                Arrays.asList(
                        Arrays.asList(1)
                ),
                permute(new int[]{1}));
        Assert.assertEquals(
                Arrays.asList(
                        Arrays.asList()
                ),
                permute(new int[]{}));
    }

}
