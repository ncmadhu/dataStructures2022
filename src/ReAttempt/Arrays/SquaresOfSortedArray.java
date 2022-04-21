package ReAttempt.Arrays;

import Common.Problem;

import java.util.Arrays;

public class SquaresOfSortedArray extends Problem {
    @Override
    public void run() {
        System.out.println("Running Squares Of Sorted Array");
        int[][] input = new int[][]{{-2, -1, 0, 2, 3}, {-3, -1, 0, 1, 2}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Output: " + Arrays.toString(this.sortedSquares(input[i])));
        }
    }

    private int[] sortedSquares(int[] arr) {
        int length = arr.length;
        int[] squares = new int[length];
        if (length == 0) return squares;
        int left, right, curr;
        left = 0;
        right = length - 1;
        curr = length - 1;
        while (left <= right) {
            if (Math.abs(arr[left]) > Math.abs(arr[right])) {
                squares[curr--] = arr[left] * arr[left];
                left++;
            } else {
                squares[curr--] = arr[right] * arr[right];
                right--;
            }
        }
        return squares;
    }
}
