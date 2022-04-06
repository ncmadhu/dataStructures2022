package Algorithms.ReAttempt1.Arrays;

import Algorithms.Algorithms;

import java.util.Arrays;

public class MaximumSubArray extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Maximum Sum SubArray");
        int[] nums;
        nums =  new int[]{1,7,-2,-5,10,-1};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output Brute Force: " + Arrays.toString(this.findMaximumSumSubArrayBF(nums)));
        System.out.println("Output: " + Arrays.toString(this.findMaximumSumSubArray(nums)));
        nums =  new int[]{5, 1, -4, 2, 3};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output Brute Force: " + Arrays.toString(this.findMaximumSumSubArrayBF(nums)));
        System.out.println("Output: " + Arrays.toString(this.findMaximumSumSubArray(nums)));
        nums =  new int[]{-5, -13, -2, -4};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output Brute Force: " + Arrays.toString(this.findMaximumSumSubArrayBF(nums)));
        System.out.println("Output: " + Arrays.toString(this.findMaximumSumSubArray(nums)));
        nums =  new int[]{-7, 6, -2};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output Brute Force: " + Arrays.toString(this.findMaximumSumSubArrayBF(nums)));
        System.out.println("Output: " + Arrays.toString(this.findMaximumSumSubArray(nums)));
    }

    private int[] findMaximumSumSubArrayBF(int[] nums) {
        int length = nums.length;
        if (length == 0 || length == 1) return nums;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        for (int i = 0; i < length; i++) {
            int sum = nums[i];
            if (sum >= maxSum) {
                maxSum = sum;
                start = i;
                end = i;
            }
            for (int j = i + 1; j < length; j++) {
                sum += nums[j];
                if (sum >= maxSum) {
                    maxSum = sum;
                    start = i;
                    end = j;
                }
            }
        }
        return Arrays.copyOfRange(nums, start, end + 1);
    }


    private int[] findMaximumSumSubArray(int[] nums) {
        int length = nums.length;
        if (length == 0) return nums;
        int left, start, end, curr, sum, maxSum;
        left = start = end = curr = 0;
        sum = 0;
        maxSum = Integer.MIN_VALUE;
        while (curr < length) {
            if (sum <= 0) {
                left = curr;
                sum =  nums[curr];
            } else {
                sum += nums[curr];
            }
            if (sum > maxSum) {
                maxSum = sum;
                start = left;
                end = curr;
            }
            curr++;
        }
        return Arrays.copyOfRange(nums, start, end + 1);
    }
}
