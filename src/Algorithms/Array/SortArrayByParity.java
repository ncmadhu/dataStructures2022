package Algorithms.Array;

import Algorithms.Algorithms;

import java.util.Arrays;

public class SortArrayByParity extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Sort Array By Parity");
        int[] nums;
        nums = new int[]{17,18,5,4,6,1};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(this.sortArrayByParity(nums)));
        nums = new int[]{};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(this.sortArrayByParity(nums)));
        nums = new int[]{2};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(this.sortArrayByParity(nums)));
        nums = new int[]{3};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(this.sortArrayByParity(nums)));
        nums = new int[]{3,3};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(this.sortArrayByParity(nums)));
        nums = new int[]{2,2};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(this.sortArrayByParity(nums)));
        nums = new int[]{3,2};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(this.sortArrayByParity(nums)));
        nums = new int[]{2,3};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(this.sortArrayByParity(nums)));
        nums = new int[]{0,1,2};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(this.sortArrayByParity(nums)));
    }

    public int[] sortArrayByParity(int[] nums) {
        int length = nums.length;
        int evenPointer = 0;
        int i = 0;
        while (i < length) {
            if (nums[i] % 2 == 0) {
                if (i != evenPointer) {
                    int temp =  nums[evenPointer];
                    nums[evenPointer] = nums[i];
                    nums[i] = temp;
                }
                evenPointer++;
            }
            i++;
        }
        return nums;
    }

}
