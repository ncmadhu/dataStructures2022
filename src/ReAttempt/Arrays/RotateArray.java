package ReAttempt.Arrays;

import Common.Problem;

import java.util.Arrays;

public class RotateArray extends Problem {
    @Override
    public void run() {
        System.out.println("Running Rotate Array");
        int[][] input = new int[][]{{1, 2, 3, 4, 5}, {1},
                {1, 2, 3, 4, 5}, {3},
                {1, 2, 3, 4, 5}, {5}};
        this.execute(input);
    }
    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            int[] nums;
            nums = Arrays.copyOfRange(input[i], 0, input[i].length);
            int shift = input[i+1][0];
            System.out.println("Input: " + Arrays.toString(nums));
            this.rightRotateArray(nums, shift);
            System.out.println("Output Right Shift By (" + shift + "): " + Arrays.toString(nums));
            nums = Arrays.copyOfRange(input[i], 0, input[i].length);
            this.leftRotateArray(nums, shift);
            System.out.println("Output Left Shift By (" + shift + "): " + Arrays.toString(nums));
        }
    }
    private void rightRotateArray(int[] arr, int shift) {
        int length = arr.length;
        if (length == 0 || length == shift) return;
        int shifted = 0;
        for (int i = 0; shifted < length; i++) {
            int curr = i;
            int prev = arr[curr];
            do {
                int next = (curr + shift) % length;
                int temp = arr[next];
                arr[next] = prev;
                prev = temp;
                curr = next;
                shifted++;
            } while (curr != i);
        }
    }

    private void leftRotateArray(int[] arr, int shift) {
        int length = arr.length;
        if (length == 0 || length == shift) return;
        int shifted = 0;
        for (int i = 0; shifted < length; i++) {
            int curr = i;
            int prev = arr[curr];
            do {
                int next = (length - shift + curr) % length;
                int temp = arr[next];
                arr[next] = prev;
                prev = temp;
                curr = next;
                shifted++;
            } while (curr != i);
        }
    }
}
