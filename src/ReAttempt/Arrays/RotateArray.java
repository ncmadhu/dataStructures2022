package ReAttempt.Arrays;

import Common.Problem;

import java.util.Arrays;

public class RotateArray extends Problem {
    @Override
    public void run() {
        System.out.println("Running Rotate Array");
        int[][] input = new int[][]{{1, 2, 3, 4, 5}, {1},
                {1, 2, 3, 4, 5}, {3},
                {1, 2, 3, 4, 5}, {5},
                {1, 2, 3, 4, 5}, {4},
                {1, 2, 3, 4, 5}, {10},
                {1, 2, 3, 4, 5}, {8}};
        this.execute(input);
    }
    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            int[] nums;
            nums = input[i].clone();
            int shift = input[i+1][0];
            System.out.println("Input: " + Arrays.toString(nums));
            this.rightRotateArray(nums, shift);
            System.out.println("Output Right Shift By (" + shift + "): " + Arrays.toString(nums));
            nums = input[i].clone();
            this.reAttemptRight(nums, shift);
            System.out.println("Output Right Shift (Re Attempt): " + Arrays.toString(nums));
            nums = input[i].clone();
            this.leftRotateArray(nums, shift);
            System.out.println("Output Left Shift By (" + shift + "): " + Arrays.toString(nums));
            nums = input[i].clone();
            this.reAttemptLeft(nums, shift);
            System.out.println("Output Left Shift (Re Attempt): " + Arrays.toString(nums));
        }
    }

    private void reAttemptRight(int[] arr, int shift) {
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

    private void reAttemptLeft(int[] arr, int shift) {
        int length = arr.length;
        if (length == 0 || length == shift) return;
        int shifted = 0;
        for (int i = 0; shifted < length; i++) {
            int curr = i;
            int prev = arr[curr];
            do {
                // Since its left shift subtract curr from shift and check for bounds within the length
                int next = (curr - shift) % length;
                // If index is negative add to length to get positive index
                if (next < 0) next = length + next;
                int temp = arr[next];
                arr[next] = prev;
                prev = temp;
                curr = next;
                shifted++;
            }while (curr != i);
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
                int next = (curr - shift) % length;
                if (next < 0) next = length + next;
                int temp = arr[next];
                arr[next] = prev;
                prev = temp;
                curr = next;
                shifted++;
            } while (curr != i);
        }
    }
}
