package ReAttempt.Arrays;

import Common.Problem;

import java.util.Arrays;

public class MinDiffElement extends Problem {
    @Override
    public void run() {
        System.out.println("Running Minimum Difference Element");
        int[][] input = new int[][]{{4, 6, 10}, {7},
                {4, 6, 10}, {4}, {1, 3, 8, 10, 15}, {12}, {4,6,10}, {10}, {1, 3, 8, 10, 15}, {14},
                {4,6,10}, {3}, {4,6,10}, {17}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Key: " + input[i+1][0]);
            System.out.println("Output: "+ this.searchMinDiffElement(input[i], input[i+1][0]));
            System.out.println("Output (Re Attempt): "+ this.searchMinDiffElement(input[i], input[i+1][0]));
        }
    }

    private int reAttempt(int[] arr, int key) {
        int length = arr.length;
        if (length == 0) return -1;
        int start, mid, end;
        start = 0;
        end = length - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == key) return key;
            if (arr[mid] < key) start = mid + 1;
            else end = mid - 1;
        }
        if (start == 0) return arr[start]; // Key is lesser than all the elements in arr
        if (start == length) return arr[start-1]; // Key is greater than all the elements in arr
        if (arr[start] - key < key - arr[end]) return arr[start];
        else return arr[end];
    }

    private int searchMinDiffElement(int[] arr, int key) {
        int length = arr.length;
        if (length == 0) return -1;
        int start, mid, end;
        start = 0;
        end = length - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == key) return arr[mid];
            if (arr[mid] > key) end = mid - 1;
            else start = mid + 1;
        }
        if (start == 0) return arr[start];
        if (start == length) return arr[start - 1];
        if ((arr[start] - key) < (key - arr[end])) return arr[start];
        else return arr[end];
    }
}
