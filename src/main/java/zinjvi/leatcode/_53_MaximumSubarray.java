package zinjvi.leatcode;

import org.junit.Assert;

public class _53_MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int prevSum = 0;

        for(int i = 0; i < nums.length; i++) {
            prevSum = Math.max(nums[i], prevSum + nums[i]);
            max = Math.max(max, prevSum);
        }
        return max;
    }

    public static void main(String[] args) {
        Assert.assertEquals(4, maxSubArray(new int[]{1, -3, 2, 1, -1, 2}));
        Assert.assertEquals(6, maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

        Assert.assertEquals(0, maxSubArray(new int[]{}));
        Assert.assertEquals(-1, maxSubArray(new int[]{-1}));
    }

}
