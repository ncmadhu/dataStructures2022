package ReAttempt.Arrays;

import Common.Problem;

import java.util.Arrays;

public class Bitonic extends Problem {
    @Override
    public void run() {
        // Bitonic - Monotonically increasing and then monotonically decreasing.
        System.out.println("Running Bitonic Array Checker");
        int[][] input = new int[][]{{1,3,8,12,4,2}, {3,8,3,1}, {1,3,8,12}, {10,9,8}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Peak: " + this.findMax(input[i]));
            System.out.println("Peak (BS): " + this.findMaxOptimum(input[i]));
            System.out.println("Peak (Re Attempt): " + this.reAttempt(input[i]));
        }
    }

    private int  reAttempt(int[] arr) {
        int length = arr.length;
        if (length == 0) return 0;
        int start, end, mid;
        start = 0;
        end = length - 1;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid+1]) end = mid;
            else start = mid + 1;
        }
        return arr[start];
    }

    private int findMax(int[] arr) {
        int length = arr.length;
        if (length == 0) return -1;
        int i = 0;
        while (i + 1 < length && arr[i] < arr[i+1]) {
            i++;
        }
        int peak = arr[i];
        while (i + 1 < length && arr[i] > arr[i+1]) {
            i++;
        }
        if (i == length - 1) return peak;
        return -1;
    }

    private int findMaxOptimum(int[] arr) {
        int length = arr.length;
        if (length == 0) return -1;
        int start = 0;
        int end = length - 1;
        int mid;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (arr[mid] < arr[mid + 1]) start = mid + 1;
            else end = mid;
        }
        return arr[start];  // or arr[end]
    }
}
