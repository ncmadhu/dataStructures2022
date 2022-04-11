package Algorithms.Array;

import Algorithms.Algorithms;

import java.util.Arrays;

public class LowHighIndexOfAnElement extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Low High Index Of An Element");
        int[][] input = new int[][]{{1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6}, {5},
                {1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 9}, {9},
                {1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 9}, {1}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Target: " + input[i + 1][0]);
            System.out.println("Low Index: " + this.findLowIndex(input[i], input[i + 1][0]));
            System.out.println("Low Index (Binary Search): " + this.findLowIndexOptimum(input[i], input[i + 1][0]));
            System.out.println("High Index: " + this.findHighIndex(input[i], input[i + 1][0]));
            System.out.println("High Index (Binary Search): " + this.findHighIndexOptimum(input[i], input[i + 1][0]));
        }
    }

    private int findHighIndex(int[] arr, int target) {
        int mid = this.binarySearch(arr, target);
        if (mid != -1) {
            int high = mid;
            while (high < arr.length && arr[high] == target) {
                high++;
            }
            return high - 1;
        }
        return -1;
    }

    private int findLowIndex(int[] arr, int target) {
        int mid = this.binarySearch(arr, target);
        if (mid != -1) {
            int low = mid;
            while (low >= 0 && arr[low] == target) {
                low--;
            }
            return low + 1;
        }
        return -1;
    }

    private int binarySearch(int[] arr, int target) {
        int length = arr.length;
        if (length == 0) return -1;
        int start, mid, end;
        start = 0;
        end = length - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    private int findLowIndexOptimum(int[] arr, int target) {
        int length = arr.length;
        if (length == 0) return -1;
        int start, mid, end;
        start = 0;
        end = length - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        if (start < arr.length && arr[start] == target) return start;
        return -1;

    }

    private int findHighIndexOptimum(int[] arr, int target) {
        int length = arr.length;
        if (length == 0) return -1;
        int start, mid, end;
        start = 0;
        end = length - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] <= target) start = mid + 1;
            else end = mid - 1;
        }
        if (end == -1) return -1;
        if (end < arr.length && arr[end] == target) return end;
        return -1;
    }
}
