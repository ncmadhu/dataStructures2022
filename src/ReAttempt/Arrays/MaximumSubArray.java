package ReAttempt.Arrays;

import Common.Problem;

import java.util.Arrays;

public class MaximumSubArray extends Problem {
    @Override
    public void run() {
        System.out.println("Running Maximum Sum SubArray");
        int[][] input = new int[][]{{1,7,-2,-5,10,-1}, {5, 1, -4, 2, 3},{-5, -13, -2, -4}, {-7, 6, -2}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            int[] nums = input[i];
            System.out.println("Input: " + Arrays.toString(nums));
            System.out.println("Output Brute Force: " + Arrays.toString(this.findMaximumSumSubArrayBF(nums)));
            System.out.println("Output: " + Arrays.toString(this.findMaximumSumSubArray(nums)));
            System.out.println("Output (Re Attempt): " + Arrays.toString(this.reAttempt(nums)));
        }
    }

    private int[] reAttempt(int[] nums) {
        int length = nums.length;
        if (length == 0) return nums;
        int left, start, curr, end;
        left = start = curr = end = 0;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        while (curr < length) {
            if (currSum <= 0) {
                left = curr;
                currSum = nums[curr];
            } else {
                currSum += nums[curr];
            }
            if (currSum > maxSum) {
                maxSum = currSum;
                start = left;
                end = curr;
            }
            curr++;
        }
        return Arrays.copyOfRange(nums, start, end+1);
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
