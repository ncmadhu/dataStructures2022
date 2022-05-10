package ReAttempt.Arrays;

import Common.Problem;

import java.util.Arrays;

public class MaxSubArrayOfSizeK extends Problem {
    @Override
    public void run() {
        System.out.println("Running Max Sub Array Of Size K");
        int[][] input = new int[][]{{2, 1, 5, 1, 3, 2}, {3}, {2, 3, 4, 1, 5}, {2}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Window Size: " + input[i+1][0]);
            System.out.println("Output (Brute Force): " + this.findMaxSubArrayOfWindowBF(input[i], input[i+1][0]));
            System.out.println("Output : " + this.findMaxSubArrayOfWindow(input[i], input[i+1][0]));
            System.out.println("Output (Re Attempt) : " + this.reAttempt(input[i], input[i+1][0]));
        }
    }

    private int reAttempt(int[] arr, int k) {
        int left, right, currsum, maxSum;
        left = right = currsum = 0;
        maxSum = Integer.MIN_VALUE;
        while (right < arr.length) {
            currsum += arr[right];
            if (right >= left + k - 1) {
                maxSum = Math.max(maxSum, currsum);
                currsum -= arr[left++];
            }
            right++;
        }
        return maxSum;
    }

    private int findMaxSubArrayOfWindowBF(int[] arr, int k) {
        int length = arr.length;
        if (length == 0) return 0;
        if (k > length) k = length;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < length - k; i++) {
            currSum = arr[i];
            for (int j = i + 1; j <= i + k - 1; j++) {
                currSum += arr[j];
            }
            if (currSum > maxSum) maxSum = currSum;
        }
        return maxSum;
    }

    private int findMaxSubArrayOfWindow(int[] arr, int k) {
        int length = arr.length;
        if (length == 0) return 0;
        if (k > length) k = length;
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int windowStart = 0;
        for (int curr = 0; curr < length; curr++) {
            windowSum += arr[curr];
            if (curr >= windowStart + k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return maxSum;
    }
}
