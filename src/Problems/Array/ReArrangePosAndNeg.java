package Problems.Array;

import Common.Problem;

import java.util.Arrays;

public class ReArrangePosAndNeg extends Problem {
    @Override
    public void run() {
        System.out.println("Running Re Arrange Pos And Neg");
        int[][] input = new int[][]{{10, -1, 20, 4, 5, -9, -6}, {10, 20, 30, -10, -20, -30}, {-10, -20, -30, 10, 20, 30},
                {10, 20, 30}, {-10, -20, -30}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            int[] nums = Arrays.copyOfRange(input[i], 0, input[i].length);
            System.out.println("Input: " + Arrays.toString(nums));
            this.reArrangeAuxSpace(nums);
            System.out.println("Output (Aux Space): " + Arrays.toString(nums));
            nums = Arrays.copyOfRange(input[i], 0, input[i].length);
            this.reArrangeNoOrderPreservation(nums);
            System.out.println("Output (In Place): " + Arrays.toString(nums));
            nums = Arrays.copyOfRange(input[i], 0, input[i].length);
            this.reArrangeWithOrderPreservation(nums);
            System.out.println("Output (In Place With order): " + Arrays.toString(nums));
        }
    }

    private void reArrangeAuxSpace(int[] nums) {
        int length = nums.length;
        if (length == 0) return;
        int[] result = new int[length];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] < 0) {
                result[index++] = nums[i];
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] >= 0) {
                result[index++] = nums[i];
            }
        }
        for (int i = 0; i < length; i++) {
            nums[i] = result[i];
        }
    }

    private void reArrangeNoOrderPreservation(int[] nums) {
        int length = nums.length;
        if (length == 0) return;
        int left, right;
        left = 0;
        right = length - 1;
        while (left < right) {
            while (left < length && nums[left] < 0) left++;
            while (right >= 0 && nums[right] >= 0) right--;
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
    }

    private void reArrangeWithOrderPreservation(int[] nums) {
        int length = nums.length;
        if (length == 0) return;
        int insPos = 0;
        int i = 0;
        while (i < length) {
            while (i < length && nums[i] >= 0) i++;
            if (i >= length) break;
            int  j = i;
            int temp = nums[i];
            while (j > insPos) {
                nums[j] = nums[j-1];
                j--;
            }
            nums[insPos++] = temp;
            i++;
        }
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

    public void reArrangeNoOrderPreservationOld(int[] nums) {
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
