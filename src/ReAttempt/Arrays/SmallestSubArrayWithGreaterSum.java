package ReAttempt.Arrays;

import Common.Problem;

import java.util.Arrays;

public class SmallestSubArrayWithGreaterSum extends Problem {
    @Override
    public void run() {
        System.out.println("Running Smallest Sub Array With Greater Sum");
        int[][] input = new int[][]{{2, 1, 5, 2, 3, 2}, {7}, {2, 1, 5, 2, 8}, {7}, {3, 4, 1, 1, 6}, {8}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Target Sum: " + input[i+1][0]);
            System.out.println("Output: " + this.findSmallestSubArray(input[i], input[i+1][0]));
            System.out.println("Output (Re Attempt): " + this.reAttempt(input[i], input[i+1][0]));
        }
    }

    private int reAttempt(int[] arr, int s) {
        int left, right, currSum, minLength;
        left = right = currSum = 0;
        minLength = Integer.MAX_VALUE;
        while (right < arr.length) {
            currSum += arr[right++];
            while (currSum >= s) {
                minLength = Math.min(minLength, right - left);
                currSum -= arr[left++];
            }
        }
        return minLength;
    }

    private int findSmallestSubArray(int[] arr, int s) {
        int length = arr.length;
        if (length == 0) return 0;
        int left, right, currSum, minLength;
        left = right = currSum = 0;
        minLength = Integer.MAX_VALUE;
        while (left < length && right < length) {
            currSum += arr[right];
            while (currSum >= s) {
                int currLength = right - left + 1;
                minLength = Math.min(minLength, currLength);
                currSum -= arr[left];
                left++;
            }
            right++;
        }
        return minLength;
    }
}
