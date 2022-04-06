package Algorithms.Array;

import Algorithms.Algorithms;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Maximum Product SubArray");
        int[] nums;
        nums =  new int[]{1,2,3,4};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Linear Output: " + this.maxProductOfThreeNumLinear(nums));
        nums =  new int[]{4,3,2,1};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Linear Output: " + this.maxProductOfThreeNumLinear(nums));
        nums =  new int[]{-100,-98,-1,2,3,4};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Linear Output: " + this.maxProductOfThreeNumLinear(nums));
    }

    private int maxProductOfThreeNumNonLinear(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int oddCondition = nums[0] * nums[1] * nums[length -1];
        int normalCondition = nums[length -1] * nums[length -2] * nums[length -3];
        return Math.max(oddCondition, normalCondition);
    }

    private int maxProductOfThreeNumLinear(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i <= min1) {
                min2 = min1;
                min1 = i;
            } else if (i <= min2) {
                min2 = i;
            }
            if (i >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = i;
            } else if (i >= max2) {
                max3 = max2;
                max2 = i;
            } else if (i >= max3) {
                max3 = i;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
