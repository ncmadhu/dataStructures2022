package Algorithms.Sorting;

import Algorithms.Algorithms;

import java.util.Arrays;

public class SquaresOfSortedArray extends Algorithms {

    public int[] sortedSquares(int[] nums) {
        int length =  nums.length;
        int[] squared = new int[nums.length];
        int left = 0;
        int right = length - 1;
        int curr = length - 1;
        while(left <= right) {
            if(Math.abs(nums[left]) > Math.abs(nums[right])) {
                squared[curr] = nums[left] * nums[left];
                left++;
            } else {
                squared[curr] = nums[right] * nums[right];
                right--;
            }
            curr--;
        }
        return squared;
    }

    @Override
    public void run() {
        System.out.println("Running Squares Of Sorted Array");
        int[] nums;
        nums =  new int[]{-7,-3,2,3,11};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + Arrays.toString(sortedSquares(nums)));
    }
}
