package Problems.Array;

import Common.Problem;

import java.util.Arrays;

public class ThreeSumCloser extends Problem {
    @Override
    public void run() {
        System.out.println("Running Three Sum Closer");
        int[][] input = new int[][]{{-2, 0, 1, 2}, {2}, {-3, -1, 1, 2}, {0}, {1, 0, 1, 1}, {100}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Target: " + input[i+1][0]);
            System.out.println("Sum Closer: " + this.searchTripletSumCloser(input[i], input[i+1][0]));
        }
    }

    private int searchTripletSumCloser(int[] arr, int target) {
        int length = arr.length;
        if (length < 3) return 0;
        int currDiff = Integer.MAX_VALUE;
        int currCloserSum = 0;
        Arrays.sort(arr);
        for (int i = 0; i < length - 2; i++) {
            int remSum = target - arr[i];
            int twoSum = this.twoSum(arr, i + 1, remSum);
            int diff = remSum - twoSum;
            if (diff == 0) return target;
            if (Math.abs(diff) < Math.abs(currDiff)) {
                currDiff = diff;
                currCloserSum = arr[i] + twoSum;
            }
        }
        return currCloserSum;
    }

    private int twoSum(int[] arr, int start, int target) {
        int left = start;
        int right = arr.length - 1;
        int sum = 0;
        while (left < right) {
            sum = arr[left] + arr[right];
            if (sum == target) return sum;
            if (sum < target) left++;
            else right--;
        }
        return sum;
    }
}
