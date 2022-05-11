package ReAttempt.Arrays;

import Common.Problem;

import java.util.Arrays;

public class MoveZeroesToLeftRight extends Problem {

    @Override
    public void run() {
        System.out.println("Running Move Zeroes To The Front");
        int[][] input = new int[][]{{1, 10, 20, 0, 59, 63, 0, 88, 0}, {0, 1, 10, 20, 0, 59, 63, 0, 88, 0},
                {0, 0, 0, 1, 10, 20, 59, 63, 88}, {1, 10, 20, 0, 59, 63, 0, 88, 0, 0, 0}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            int[] arr;
            System.out.println("Input: " + Arrays.toString(input[i]));
            arr = input[i].clone();
            this.moveZeroesLeft(arr);
            System.out.println("Zeroes Left: " + Arrays.toString(arr));
            this.reAttemptMoveLeft(arr);
            System.out.println("Zeroes Left (Re Attempt): " + Arrays.toString(arr));
            arr = input[i].clone();
            this.moveZeroesRight(arr);
            System.out.println("Zeroes Right: " + Arrays.toString(arr));
            arr = input[i].clone();
            this.reAttemptMoveRight(arr);
            System.out.println("Zeroes Right (Re Attempt): " + Arrays.toString(arr));
        }
    }
    private void reAttemptMoveLeft(int[] arr) {
        int length = arr.length;
        if (length == 0) return;
        int left, right;
        left = right = length - 1;
        while (left >= 0) {
            if (arr[left] != 0) arr[right--] = arr[left];
            left--;
        }
        while (right >= 0) arr[right--] = 0;
    }

    private void reAttemptMoveRight(int[] arr) {
        int length = arr.length;
        if (length == 0) return;
        int left, right;
        left = right = 0;
        while (right < length) {
            if (arr[right] != 0) arr[left++] = arr[right];
            right++;
        }
        while (left < length) arr[left++] = 0;
    }
    private void moveZeroesLeft(int[] arr) {
        int length = arr.length;
        if (length == 0) return;
        int read , write;
        read = write = length - 1;
        while (read >= 0) {
            if (arr[read] != 0) {
                arr[write] = arr[read];
                write--;
            }
            read--;
        }
        while (write >= 0) {
            arr[write] = 0;
            write--;
        }
    }

    private void moveZeroesRight(int[] arr) {
        int length = arr.length;
        if (length == 0) return;
        int read, write;
        read = write = 0;
        while (read < length) {
            if (arr[read] != 0) {
                arr[write] = arr[read];
                write++;
            }
            read++;
        }
        while (write < length) {
            arr[write] = 0;
            write++;
        }
    }

    private void moveZeroesLeftO(int[] arr) {
        int length =  arr.length;
        if (length == 0) return;
        int read, write;
        read = write = length - 1;
        while (read >= 0) {
            if (arr[read] != 0) {
                arr[write] = arr[read];
                write--;
            }
            read--;
        }
        for (int i = 0; i <= write; i++) {
            arr[i] = 0;
        }
    }

    private void moveZeroesRightO(int[] arr) {
        int length = arr.length;
        if (length == 0) return;
        int read, write;
        read = write = 0;
        while (read < length) {
            if (arr[read] != 0) {
                arr[write] = arr[read];
                write++;
            }
            read++;
        }
        while (write < length) {
            arr[write] = 0;
            write++;
        }
    }
}
