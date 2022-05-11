package ReAttempt.Arrays;

import Common.Problem;

import java.util.Arrays;

public class CeilingOfNumber extends Problem {
    @Override
    public void run() {
        System.out.println("Running Ceiling Of Number");
        int[][] input = new int[][]{{4,6,10}, {-1}, { 1, 3, 8, 10, 15 }, {12},  { 4, 6, 10 }, {17}, { 4, 6, 10 }, {6}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            System.out.println(("Input: " + Arrays.toString(input[i])));
            System.out.println(("Ceiling Of " + input[i+1][0] + ": " + this.searchCeiling(input[i], input[i+1][0])));
            System.out.println(("Ceiling Of (Re Attempt)" + input[i+1][0] + ": " + this.reAttempt(input[i], input[i+1][0])));
        }
    }

    private int reAttempt(int[] arr, int n) {
        int length = arr.length;
        // if last number is lesser than the n, then there can be no number in the array
        // which is equal or greater than the n since array is sorted
        if (length == 0 || arr[length - 1] < n) return -1;
        int start, mid, end;
        start = 0;
        end = length - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == n) return mid;
            if (arr[mid] < n) start = mid + 1;
            else end = mid - 1;
        }
        if (start < length && arr[start] > n) return start;
        return - 1;
    }

    private int searchCeiling(int[] arr, int n) {
        int length = arr.length;
        if (length == 0 || n > arr[length- 1]) return -1;
        int start, mid, end;
        start = 0;
        end = length - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == n) return mid;
            if (arr[mid] > n) end = mid - 1;
            else start = mid + 1;
        }
        // If n is not found start will be the number one larger than the n
        return start;
    }
}
