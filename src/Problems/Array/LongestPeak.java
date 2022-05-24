package Problems.Array;

import Common.Problem;

import java.util.Arrays;

public class LongestPeak extends Problem {
    @Override
    public void run() {
        System.out.println("Running Longest Peak");
        int[][] input = new int[][] {{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3},
                                     {5, 4, 3, 2, 1, 2, 10, 12},
                                     {1, 2, 3, 4, 5, 6, 10, 100, 1000},
                                     {1, 2, 3, 3, 2, 1},
                                     {1, 2, 3, 2, 1, 1},
                                     {5, 4, 3, 2, 1, 2, 1},
                                     {1, 3, 2},
                                     {1, 2, 3, 4, 5, 1},
                                     {},
                                     {1, 1, 3, 2, 1},
                                     {1, 2, 3, 3, 4, 0, 10},
                                     {1, 1, 1, 2, 3, 10, 12, -3, -3, 2, 3, 45, 800, 99, 98, 0, -1, -1, 2, 3, 4, 5, 0, -1, -1}
        };
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Longest Peak: " + this.longestPeak(input[i]));
            System.out.println("Longest Peak (BS): " + this.longestPeakBS(input[i]));
        }
    }

    private int longestPeak(int[] array) {
        int length = array.length;
        if (length < 3) return 0;
        int maxCount = 0;
        int i = 0;
        while (i < length-2) {
            int currStart = i;
            int j = i + 1;
            while (j < length - 1 && array[i] < array[j]) {
                i++;
                j++;
            }
            if (array[i] == array[j] || i == currStart) {
                i++;
                continue;
            }
            if (j == length - 1 && array[i] <= array[j]) break;
            while (j < length && array[i] > array[j]) {
                i++;
                j++;
            }
            maxCount = Math.max(maxCount, j - currStart);
        }
        return maxCount;
    }

    private int longestPeakBS(int[] array) {
        int length = array.length;
        if (length < 3) return 0;
        int maxCount = 0;
        int i = 1;
        while (i < length-1) {
            // Find an i(peak) which satisfies the condition /i\
            boolean isPeak = array[i-1] < array[i] && array[i] > array[i+1];
            if (!isPeak) {
                i++;
                continue;
            }
            // We found a peak. Expand left until it is arr[i-1] < arr[i]
            int leftIdx = i - 2;
            while (leftIdx >= 0 && array[leftIdx] < array[leftIdx+1]) leftIdx--;
            // Expand right until arr[i] > arr[i+1]
            int rightIdx = i + 2;
            while (rightIdx < length && array[rightIdx-1] > array[rightIdx]) rightIdx++;
            maxCount = Math.max(maxCount, rightIdx - leftIdx - 1);
            // Move i to rightIdx since we processed all elements before right idx
            i = rightIdx;
        }
        return maxCount;
    }
}
