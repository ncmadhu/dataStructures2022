package Algorithms.Array;

import Algorithms.Algorithms;

import java.util.Arrays;

public class ReArrangePosAndNeg extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Re Arrange Pos And Neg");
        int[] nums;
        nums =  new int[]{10,-1,20,4,5,-9,-6};
        System.out.println("Input: " + Arrays.toString(nums));
        this.reArrange(nums);
        System.out.println("Output: " + Arrays.toString(nums));
        nums =  new int[]{10,-1,20,4,5,-9,-6};
        System.out.println("Input: " + Arrays.toString(nums));
        this.reArrangeNoOrderPreservation(nums);
        System.out.println("Output: " + Arrays.toString(nums));
    }

    public void reArrange(int[] nums) {
        int length =  nums.length;
        int i = 0;
        int insPos = 0;
        while (i < length) {
            if (nums[i] < 0) {
                int j = i;
                int curr = nums[j];
                while (j > insPos) {
                    nums[j] = nums[j-1];
                    j--;
                }
                nums[insPos] = curr;
                insPos++;
            }
            i++;
        }
    }

    public void reArrangeNoOrderPreservation(int[] nums) {
        int length = nums.length;;
        int i = 0;
        int insPos = 0;
        while (i < length) {
            if (nums[i] < 0) {
                int temp = nums[insPos];
                nums[insPos] = nums[i];
                nums[i] = temp;
                insPos++;
            }
            i++;
        }
    }
}
