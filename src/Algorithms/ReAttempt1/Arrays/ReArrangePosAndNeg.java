package Algorithms.ReAttempt1.Arrays;

import Algorithms.Algorithms;

import java.util.Arrays;

public class ReArrangePosAndNeg extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Re Arrange Positive And Negative Values");
        int[] nums;
        nums = new int[]{-10, -1, 20, 4, 5, -9, -6};
        System.out.println("Input: " + Arrays.toString(nums));
        this.reArrange(nums);
        System.out.println("Output: " + Arrays.toString(nums));
        nums = new int[]{-10, -1, 20, 4, 5, -9, -6};
        this.reArrangeWithOrder(nums);
        System.out.println("Output (Order Preservation): " + Arrays.toString(nums));
        nums = new int[]{-10, -1, 20, 4, 5, -9, -6};
        this.reArrangeWithOrderUsingAuxSpace(nums);
        System.out.println("Output (Aux Space): " + Arrays.toString(nums));
        nums = new int[]{10, -1, 20, 4, 5, -9, -6};
        System.out.println("Input: " + Arrays.toString(nums));
        this.reArrange(nums);
        System.out.println("Output: " + Arrays.toString(nums));
        nums = new int[]{10, -1, 20, 4, 5, -9, -6};
        this.reArrangeWithOrder(nums);
        System.out.println("Output (Order Preservation): " + Arrays.toString(nums));
        nums = new int[]{10, -1, 20, 4, 5, -9};
        System.out.println("Input: " + Arrays.toString(nums));
        this.reArrange(nums);
        System.out.println("Output: " + Arrays.toString(nums));
        nums = new int[]{10, -1, 20, 4, 5, -9};
        this.reArrangeWithOrder(nums);
        System.out.println("Output (Order Preservation): " + Arrays.toString(nums));
        nums = new int[]{-1,-2, -3, -4};
        System.out.println("Input: " + Arrays.toString(nums));
        this.reArrange(nums);
        System.out.println("Output: " + Arrays.toString(nums));
        nums = new int[]{-1,-2, -3, -4};
        this.reArrangeWithOrder(nums);
        System.out.println("Output (Order Preservation): " + Arrays.toString(nums));
        nums = new int[]{1,2, 3, 4};
        System.out.println("Input: " + Arrays.toString(nums));
        this.reArrange(nums);
        System.out.println("Output: " + Arrays.toString(nums));
        nums = new int[]{1,2, 3, 4};
        this.reArrangeWithOrder(nums);
        System.out.println("Output (Order Preservation): " + Arrays.toString(nums));
    }

    private void reArrange(int[] nums) {
        if (nums.length == 0) return;
        int insPos = 0;
        int currPos = 0;
        while (currPos < nums.length) {
            if (nums[currPos] < 0) {
                int temp = nums[insPos];
                nums[insPos] = nums[currPos];
                nums[currPos] = temp;
                insPos++;
            }
            currPos++;
        }
    }

    private void reArrangeWithOrder(int[] nums) {
        if (nums.length == 0) return;
        int insPos = 0;
        int currPos = 0;
        while (currPos < nums.length) {
            if (nums[currPos] < 0) {
                int temp = nums[currPos];
                int  j = currPos - 1;
                while ( j >= insPos) {
                    nums[j+1] = nums[j];
                    j--;
                }
                nums[insPos] = temp;
                insPos++;
            }
            currPos++;
        }
    }

    private void reArrangeWithOrderUsingAuxSpace(int[] nums) {
        int length = nums.length;
        if (length == 0) return;
        int[] arrangedArray =  new int[length];
        int arrangedArrayIdx = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] < 0) {
                arrangedArray[arrangedArrayIdx++] = nums[i];
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                arrangedArray[arrangedArrayIdx++] = nums[i];
            }
        }
        for (int i = 0; i < length; i++) {
            nums[i] = arrangedArray[i];
        }
    }
}
