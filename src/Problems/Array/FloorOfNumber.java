package Problems.Array;

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
        }
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
