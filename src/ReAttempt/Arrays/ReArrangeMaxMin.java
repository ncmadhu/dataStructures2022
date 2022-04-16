package ReAttempt.Arrays;

import Common.Problem;

import java.util.Arrays;

public class ReArrangeMaxMin extends Problem {
    @Override
    public void run() {
        System.out.println("Running Re Arrange Maximum and Minimum Values");
        int[] nums;
        nums = new int[]{1,2,3,4,5,6};
        System.out.println("Input: " + Arrays.toString(nums));
        this.reArrangeNonOptimum(nums);
        System.out.println("Output: " + Arrays.toString(nums));
        nums = new int[]{7,10,11,15,20};
        System.out.println("Input: " + Arrays.toString(nums));
        this.reArrange(nums);
        System.out.println("Output: " + Arrays.toString(nums));
        nums = new int[]{-6,-1,-2,5,8};
        System.out.println("Input: " + Arrays.toString(nums));
        this.reArrangeNonOptimum(nums);
        System.out.println("Output: " + Arrays.toString(nums));
    }

    private void reArrangeNonOptimum(int[] nums) {
        int length = nums.length;
        if (length == 0) return;
        int newArr[] = new int[length];
        int maxIdx = length - 1;
        int minIdx = 0;
        for (int i = 0; i < length; i++) {
            if ( i % 2 == 0) {
                newArr[i] = nums[maxIdx];
                maxIdx--;
            } else {
                newArr[i] = nums[minIdx];
                minIdx++;
            }
        }
        for (int i = 0; i < length; i++) {
            nums[i] = newArr[i];
        }
    }

    private void reArrange(int[] nums) {
        int length = nums.length;
        if (length == 0) return;
        // Max/Min element is stored in the multiplied amount
        // Original element at index is stored as remainder by adding it to the multiplied amount
        int maxIdx = length - 1;
        int minIdx = 0;
        int multiplier = nums[maxIdx] + 5;
        for (int i = 0; i < length; i++) {
            // Even index is for max value and odd index for min value
            // Modulo is done to get the original value at that index
            // Because maxIdx and minIdx are getting the value from the modified array
            if ( i % 2 == 0) {
                nums[i] = nums[i] + (nums[maxIdx] % multiplier) * multiplier;
                maxIdx--;
            } else {
                nums[i] = nums[i] + (nums[minIdx] % multiplier) * multiplier;
                minIdx++;
            }
        }
        for (int i = 0; i < length; i++) {
            // To get the max min values divide by the multiplier
            // Which gives the quotient leaving out the remainder which removes the original value at that index
            nums[i] = nums[i] / multiplier;
        }
    }
}
