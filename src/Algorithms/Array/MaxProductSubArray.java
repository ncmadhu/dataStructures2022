package Algorithms.Array;

import Algorithms.Algorithms;

import java.util.Arrays;

public class MaxProductSubArray extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Maximum Product SubArray");
        int[] nums;
        nums =  new int[]{2,3,-2,4};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Linear Output: " + this.maxProductSubArrayLinear(nums));
        nums =  new int[]{-2,0,-1};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Linear Output: " + this.maxProductSubArrayLinear(nums));
        nums =  new int[]{-3,-1,-1};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Linear Output: " + this.maxProductSubArrayLinear(nums));
        nums =  new int[]{0,2};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Linear Output: " + this.maxProductSubArrayLinear(nums));
        nums =  new int[]{-2,3,-4};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Linear Output: " + this.maxProductSubArrayLinear(nums));
        nums =  new int[]{-1,-2,-9,-6};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Linear Output: " + this.maxProductSubArrayLinear(nums));
    }

    private int maxProductSubArrayLinear(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        int currMax = nums[0];
        int currMin = nums[0];
        int result =  currMax;
        for (int i = 1; i < length; i++) {
            int curr = nums[i];
            int tempMax = Math.max(curr, Math.max(currMax * curr, currMin * curr));
            currMin = Math.min(curr, Math.min(currMax * curr, currMin * curr));
            currMax = tempMax;

            result = Math.max(result, currMax);
        }
        return result;
    }
}
