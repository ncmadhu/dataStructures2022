package Algorithms.ReAttempt1.Arrays;

import Algorithms.Algorithms;

import java.util.Arrays;

public class SecondMaximum extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Second Maximum");
        int[] nums;
        nums = new int[]{9,2,3,2,6,6};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.findSecondMaximum(nums));
    }

    private int findSecondMaximum(int[] nums) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= firstMax) {
                secondMax = firstMax;
                firstMax = nums[i];
            } else if (nums[i] >= secondMax) {
                secondMax = nums[i];
            }
        }
        return secondMax;
    }
}
