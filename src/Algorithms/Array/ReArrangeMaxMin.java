package Algorithms.Array;

import Algorithms.Algorithms;

import java.util.Arrays;

public class ReArrangeMaxMin extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Re Arrange Max And Min");
        int[] nums;
        nums =  new int[]{1,2,3,4,5,6,7};
        System.out.println("Input: " + Arrays.toString(nums));
        this.reArrange(nums);
        System.out.println("Output: " + Arrays.toString(nums));
    }

    public void reArrange(int[] nums) {
        int length = nums.length;
        int maxIdx = length - 1;
        int minIdx = 0;
        int maxElem = nums[maxIdx] + 1;
        // original element at index is stored as remainder
        // max/min values stored as multipliers
        for (int i = 0; i< length; i++) {
            if (i % 2 == 0) {
                nums[i] += (nums[maxIdx] % maxElem) * maxElem;
                maxIdx--;
            } else {
                nums[i] += (nums[minIdx] % maxElem) * maxElem;
                minIdx++;
            }
        }
        for (int i = 0; i < length; i++) {
            nums[i] = nums[i] / maxElem;
        }
    }
}
