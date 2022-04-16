package Problems.Array;

import Common.Problem;

import java.util.Arrays;

public class TwoSumSmaller extends Problem {
    @Override
    public void run() {
        System.out.println("Running Two Sum Smaller Than k");
        int[] nums;
        int k;
        nums =  new int[]{-2,0,1,4};
        k = 3;
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Brute Force: " + this.twoSumSmallerBruteForce(nums, k));
        System.out.println("Two Pointer: " + this.twoSumSmallerTwoPointer(nums, k));
        nums =  new int[]{3,5,2,8,1};
        k = 7;
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Brute Force: " + this.twoSumSmallerBruteForce(nums, k));
        System.out.println("Two Pointer: " + this.twoSumSmallerTwoPointer(nums, k));
        nums =  new int[]{34,23,1,24,75,33,54,8};
        k = 60;
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Brute Force: " + this.twoSumSmallerBruteForce(nums, k));
        System.out.println("Two Pointer: " + this.twoSumSmallerTwoPointer(nums, k));
        nums =  new int[]{10,20,30};
        k = 15;
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Brute Force: " + this.twoSumSmallerBruteForce(nums, k));
        System.out.println("Two Pointer: " + this.twoSumSmallerTwoPointer(nums, k));
    }

    private int twoSumSmallerTwoPointer(int[] nums, int k) {
        int maxSumLessThanK = -1;
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        Arrays.sort(nums);
        while (left < right) {
            int sum = nums[left] + nums[right];
            if ( sum < k) {
                left++;
                if (sum > maxSumLessThanK) {
                    maxSumLessThanK = sum;
                }
            } else {
                right--;
            }
        }
        return maxSumLessThanK;
    }


    private int twoSumSmallerBruteForce(int[] nums, int k) {
        int maxSumLessThanK = -1;
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int sum = nums[i] + nums[j];
                if (sum < k && sum > maxSumLessThanK) {
                    maxSumLessThanK = sum;
                }
            }
        }
        return maxSumLessThanK;
    }
}
