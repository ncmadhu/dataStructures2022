package Problems.Array;

import Common.Problem;

import java.util.Arrays;

public class OrderAgnosticBinarySearch extends Problem {
    @Override
    public void run() {
        System.out.println("Running Order Agnostic Binary Search");
        int[][] input = new int[][]{{4,6,10}, {10}, {1,2,3,4,5,6,7}, {5}, {10,6,4}, {10}, {10,6,4}, {4}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Target: " + input[i+1][0]);
            System.out.println("Output: " + this.orderAgnosticBinarySearch(input[i], input[i+1][0]));
        }
    }

    private int orderAgnosticBinarySearch(int[] arr, int key) {
        int length = arr.length;
        if (length == 0) return -1;
        String order = "ASC";
        if (arr[0] > arr[length-1]) order = "DESC";
        int start, mid, end;
        start = 0;
        end = length - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == key) return mid;
            if (arr[mid] > key) {
                if (order.equals("DESC")) start = mid + 1;
                else end = mid - 1;
            } else {
                if (order.equals("DESC")) end = mid - 1;
                else start = mid + 1;
            }
        }
        return -1;
    }
}
