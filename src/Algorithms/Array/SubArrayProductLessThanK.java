package Algorithms.Array;

import Algorithms.Algorithms;

import java.util.Arrays;

public class SubArrayProductLessThanK extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running SubArray Product Less Than K");
        int[] nums;
        int k;
        nums =  new int[]{10,5,2,6};
        k = 100;
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + numSubarrayProductLessThanK(nums, k));
        System.out.println("Output: " + numSubarrayProductLessThanKEfficient(nums, k));
        nums =  new int[]{1,2,3};
        k = 0;
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + numSubarrayProductLessThanKEfficient(nums, k));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int start, curr, prod, length;
        start = curr = -1;
        prod = 0;
        length = nums.length;
        while(start < length) {
            if (prod == 0) {
                start = start + 1;
                if (start < length) {
                    curr = start;
                    prod = nums[curr];
                    if (prod < k) {
                        count++;
                    }
                }
            } else {
                curr++;
                if (curr < length) {
                    prod = prod * nums[curr];
                    if (prod < k) {
                        count++;
                    } else {
                        prod = 0;
                    }
                } else {
                    prod = 0;
                }
            }
        }
        return count;
    }
    public int numSubarrayProductLessThanKEfficient(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            // If prod becomes greater than K slide left pointer until
            // prod less than k
            while (prod >= k) prod /= nums[left++];
            // add number of sub array pairs less than k to the count
            // [x,[y,[z]]]
            ans += right - left + 1;
        }
        return ans;
    }
}
