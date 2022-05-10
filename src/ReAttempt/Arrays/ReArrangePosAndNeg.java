package ReAttempt.Arrays;

import Common.Problem;

import java.util.Arrays;

public class ReArrangePosAndNeg extends Problem {
    @Override
    public void run() {
        System.out.println("Running Re Arrange Positive And Negative Values");
        int[][] input = new int[][]{{-10, -1, 20, 4, 5, -9, -6},{10, -1, 20, 4, 5, -9},
                {-1,-2, -3, -4},{1,2, 3, 4}};
        this.execute(input);
    }
    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            int[] nums;
            nums = input[i].clone();
            System.out.println("Input: " + Arrays.toString(nums));
            this.reArrange(nums);
            System.out.println("Output: " + Arrays.toString(nums));
            nums = input[i].clone();
            this.reAttempt(nums);
            System.out.println("Output (Re Attempt): " + Arrays.toString(nums));
            nums = input[i].clone();
            this.reArrangeWithOrder(nums);
            System.out.println("Output (Order Preservation): " + Arrays.toString(nums));
            nums = input[i].clone();
            this.reAttemptWithOrderPreservation(nums);
            System.out.println("Output (Re Attempt Order Preservation): " + Arrays.toString(nums));
            nums = input[i].clone();
            this.reArrangeWithOrderUsingAuxSpace(nums);
            System.out.println("Output (Aux Space): " + Arrays.toString(nums));
        }
    }

    private void reAttempt(int[] nums) {
        int length = nums.length;
        if (length == 0) return;
        int left, right;
        left = 0;
        right = length - 1;
        while (left < right) {
            while (left < length && nums[left] < 0) {
                left++;
            }
            while (right >=0  && nums[right] >= 0) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
    }

    private void reAttemptWithOrderPreservation(int[] nums) {
        int length = nums.length;
        if (length == 0) return;
        int left, right;
        left = 0;
        right = 0;
        while (right < length) {
            if (nums[right] < 0) {
                int j = right;
                int temp = nums[right];
                while (j > left) {
                    nums[j] = nums[j-1];
                    j--;
                }
                nums[j] = temp;
                left++;
            }
            right++;
        }
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
