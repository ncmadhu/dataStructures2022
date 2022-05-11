package ReAttempt.Arrays;

import Common.Problem;

import java.util.Arrays;

public class SearchRotatedArray extends Problem {
    @Override
    public void run() {
        System.out.println("Running Search In Rotated Array");
        int[][] input = new int[][]{{6, 7, 1, 2, 3, 4, 5}, {3},
                {6, 7, 1, 2, 3, 4, 5}, {6},
                {4, 5, 6, 1, 2, 3}, {3},
                {4, 5, 6, 1, 2, 3}, {6}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Target: " + input[i+1][0]);
            System.out.println("Output (Optimum): " + this.binarySearchRotated(input[i], input[i+1][0]));
            System.out.println("Output (Re Attempt): " + this.reAttemptBinSearchRotated(input[i], input[i+1][0]));
        }
    }

    private int reAttemptBinSearchRotated(int[] arr, int target) {
        int length = arr.length;
        if (length == 0) return -1;
        int start, mid, end;
        start = 0;
        end = length - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target) return mid;
            // Find which half is sorted
            if (arr[start] <= arr[mid]) {
                // Left is sorted
                if (arr[start] <= target && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // Right is sorted
                if (arr[mid] < target && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
    // Find the half which is sorted
    // Check for the target in the sorted half
    // If not present, in the sorted half move the start or end pointer accordingly
    private int binarySearchRotated(int[] arr, int target) {
        int length = arr.length;
        if (length == 0) return -1;
        int mid, start = 0;
        int end = length - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target) return mid;

            if (arr[start] <= arr[mid]) {
                // start to mid is sorted
                if (arr[start] <= target && target <= arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // mid to end is sorted
                if (arr[mid] <= target && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    private int binarySearchRotatedNonOptimum(int[] arr, int target) {
        // First determine the number of rotations
        int length = arr.length;
        if (length == 0) return -1;
        int rotated = 0;
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] == target) return i;
            if (arr[i] > arr[i+1]) {
                rotated = i + 1;
                break;
            }
        }
        int start, end, mid;
        if (arr[rotated] <= target && target <= arr[length - 1]) {
            start = rotated;
            end = length;
        } else {
            start = 0;
            end = rotated - 1;
        }
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }
}
