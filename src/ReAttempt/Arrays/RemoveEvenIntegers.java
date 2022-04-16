package ReAttempt.Arrays;

import Common.Problem;

import java.util.Arrays;

public class RemoveEvenIntegers extends Problem {
    @Override
    public void run() {
        System.out.println("Running Remove Even");
        int[][] input = new int[][]{{13, 19, 9, 5, 12, 8, 7, 4, 21, 2, 6, 11}, {1}, {2, 4}, {1, 3}, {2}, {}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Output: " + Arrays.toString(this.removeEven(input[i])));
            this.removeEvenInPlace(input[i]);
            System.out.println("Output (In Place): " + Arrays.toString(input[i]));
        }
    }

    private void removeEvenInPlace(int[] nums) {
        int length = nums.length;
        if (length == 0) return;
        int insPos = 0;
        int i = 0;
        while (i < length) {
            if (nums[i] % 2 != 0) {
                nums[insPos++] = nums[i];
            }
            i++;
        }
        while (insPos < length) {
            nums[insPos++] = 0;
        }
    }

    private int[] removeEven(int[] nums) {
        int length = nums.length;
        if (length == 0) return new int[0];
        // Count the odd elements to init array
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] % 2 != 0) count++;
        }
        int[] oddArray =  new int[count];
        if (count > 0) {
            int index = 0;
            for (int  i = 0; i < length; i++) {
                if (nums[i] % 2 != 0) oddArray[index++] = nums[i];
            }
        }
        return oddArray;
    }
}
