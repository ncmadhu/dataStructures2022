package ReAttempt.Arrays;

import Common.Problem;

import java.util.Arrays;

public class FloorOfNumber extends Problem {
    @Override
    public void run() {
        System.out.println("Running Floor Of Number");
        int[][] input = new int[][]{{4,6,10}, {-1}, { 1, 3, 8, 10, 15 }, {12},  { 4, 6, 10 }, {17}, { 4, 6, 10 }, {6}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            System.out.println(("Input: " + Arrays.toString(input[i])));
            System.out.println(("Floor Of " + input[i+1][0] + ": " + this.searchFloor(input[i], input[i+1][0])));
            System.out.println(("Floor Of (Re Attempt) " + input[i+1][0] + ": " + this.reAttempt(input[i], input[i+1][0])));
        }
    }
    private int reAttempt(int[] arr, int n) {
        int length = arr.length;
        // If first element of the array itself is greater than n, then no number can in the array
        // which is equal or lesser than n since array is sorted
        if (length == 0 || arr[0] > n) return -1;
        int start, mid, end;
        start = 0;
        end = length - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == n) return mid;
            if (arr[mid] < n) start = mid + 1;
            else end = mid - 1;
        }
        return end;
    }

    private int searchFloor(int[] arr, int n) {
        int length = arr.length;
        if (length == 0 || arr[0] > n) return -1;
        int start, mid, end;
        start = 0;
        end = length - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == n) return mid;
            if (arr[mid] > n) end = mid - 1;
            else start = mid + 1;
        }
        // If n is not found end will be the number one larger than the n
        return end;
    }
}
