package Algorithms.Array;

import Algorithms.Algorithms;

import java.util.Arrays;

public class MoveZeroes extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Move Zeroes");
        int[] nums;
        nums = new int[]{0,1,0,3,12};
        System.out.println(("Input: " + Arrays.toString(nums)));
        this.moveZeroes(nums);
        System.out.println("Output: " + Arrays.toString(nums));
        nums = new int[]{1};
        System.out.println(("Input: " + Arrays.toString(nums)));
        this.moveZeroes(nums);
        System.out.println("Output: " + Arrays.toString(nums));
        nums = new int[]{0,0,0,0,1};
        System.out.println(("Input: " + Arrays.toString(nums)));
        this.moveZeroes(nums);
        System.out.println("Output: " + Arrays.toString(nums));
        nums = new int[]{0};
        System.out.println(("Input: " + Arrays.toString(nums)));
        this.moveZeroes(nums);
        System.out.println("Output: " + Arrays.toString(nums));
    }
    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;
        int length = nums.length;
        for(int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                int temp = nums[nonZeroIndex];
                nums[nonZeroIndex] = nums[i];
                nums[i] = temp;
                nonZeroIndex++;
            }
        }
    }
}
