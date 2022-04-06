package Algorithms.Array;

import Algorithms.Algorithms;

import java.util.Arrays;
import java.util.List;

public class MaxSubArray extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Maximum SubArray");
        int[] nums;
        nums =  new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Linear Output: " + Arrays.toString(this.maxSubArrayLinear(nums)));
        System.out.println("Divide And Conquer Output: " + Arrays.toString(this.maxSubArrayDivAndConquer(nums)));
        nums =  new int[]{5,4,-1,7,8};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("O(n2) Output: " + Arrays.toString(this.maxSubArrayOn2(nums)));
        System.out.println("Divide And Conquer Output: " + Arrays.toString(this.maxSubArrayDivAndConquer(nums)));
    }

    private int[] maxSubArrayOn2(int[] nums) {
        int length = nums.length;
        int max = Integer.MIN_VALUE;
        int maxRight = 0;
        int maxLeft = 0;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                sum =  sum + nums[j];
                if (sum > max) {
                    max =  sum;
                    maxLeft = i;
                    maxRight = j;
                }
            }
        }
       return Arrays.copyOfRange(nums,maxLeft, maxRight + 1);
    }

    private int[] maxSubArrayLinear(int[] nums) {
        int bestSum = Integer.MIN_VALUE;
        int currSum = 0;
        int length = nums.length;
        int bestStart = 0;
        int bestEnd = 0;
        int currStart = 0;

        for (int i = 0; i < length; i++) {
            if (currSum <= 0) {
                currStart = i;
                currSum = nums[i];
            } else {
                currSum += nums[i];
            }

            if (currSum > bestSum) {
                bestSum = currSum;
                bestStart = currStart;
                bestEnd = i;
            }
        }
        return Arrays.copyOfRange(nums, bestStart, bestEnd + 1);
    }

    private int[] maxSubArrayDivAndConquer(int[] nums) {
        List<Integer> subArray = maxSubArray(nums, 0, nums.length - 1);
        return Arrays.copyOfRange(nums, subArray.get(0), subArray.get(1) + 1);
    }

    private List<Integer> maxSubArray(int[] nums, int low, int high) {
        if (high == low) {
            return Arrays.asList(low, high, nums[low]);
        }
        int mid = (low + high) / 2;
        List<Integer> leftValues = maxSubArray(nums, low, mid);
        List<Integer> rightValues = maxSubArray(nums, mid+1, high);
        List<Integer> crossValues = maxSubArrayCrossOver(nums, low, mid, high);
        int leftSum = leftValues.get(2);
        int rightSum = rightValues.get(2);
        int crossOverSum = crossValues.get(2);
        if ( leftSum >= rightSum && leftSum >= crossOverSum) {
            return leftValues;
        } else if (rightSum >= leftSum && rightSum >= crossOverSum) {
            return rightValues;
        } else {
            return crossValues;
        }
    }

    private List<Integer> maxSubArrayCrossOver(int[] nums, int low, int mid, int high) {
        int sum = 0;
        int leftMax = Integer.MIN_VALUE;
        int maxLeft = mid;
        for (int i = mid; i >= low; i--) {
            sum = sum + nums[i];
            if (sum > leftMax) {
                leftMax = sum;
                maxLeft = i;
            }
        }
        sum = 0;
        int rightMax = Integer.MIN_VALUE;
        int maxRight = mid + 1;
        for (int i = mid + 1; i <= high; i++) {
            sum = sum + nums[i];
            if (sum > rightMax) {
                rightMax = sum;
                maxRight = i;
            }
        }
        return Arrays.asList(maxLeft, maxRight, leftMax + rightMax);
    }

}
