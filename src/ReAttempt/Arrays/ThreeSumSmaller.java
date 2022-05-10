package ReAttempt.Arrays;

import Common.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumSmaller extends Problem {
    @Override
    public void run() {
        System.out.println("Running Three Sum Smaller");
        int[][] input = new int[][]{{-2, 0, 1, 3}, {2}, {3, 5, 2, 8, 1}, {7}, {-1, 0, 2, 3}, {3}, {-1, 4, 2, 1, 3}, {5}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Target: " + input[i+1][0]);
            System.out.println("Triplets less than target: " + this.threeSumSmaller(input[i], input[i+1][0]));
            System.out.println("Triplets less than target: " + this.tripletSmaller(input[i], input[i+1][0]));
        }
    }

    private List<List<Integer>> tripletSmaller(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int length = arr.length;
        if (length < 3) return result;
        Arrays.sort(arr);
        for (int i = 0; i < length - 2; i++) {
            this.doubleSmaller(arr, i + 1, target - arr[i], result);
        }
        return result;
    }

    private void doubleSmaller(int[] arr, int start, int rem, List<List<Integer>> result) {
        int left = start;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] >= rem) right--;
            else {
                for (int i = right; i > left; i--) {
                    List<Integer> subList = new ArrayList<>();
                    subList.add(arr[start-1]);
                    subList.add(arr[left]);
                    subList.add(arr[i]);
                    result.add(subList);
                }
                left++;
            }
        }
    }

    private int threeSumSmaller(int[] arr, int target) {
        int length = arr.length;
        if (length < 3) return 0;
        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < length - 2; i++) {
            count += this.twoSumSmaller(arr, i+1, target - arr[i]);
        }
        return count;
    }

    private int twoSumSmaller(int[] arr, int start, int target) {
        int count = 0;
        int left = start;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] >= target) right--;
            else {
                count += right - left;
                left++;
            }
        }
        return count;
    }


}
