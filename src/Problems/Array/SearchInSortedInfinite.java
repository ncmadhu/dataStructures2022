package Problems.Array;

import Common.Problem;

import java.util.Arrays;

public class SearchInSortedInfinite extends Problem {
    @Override
    public void run() {
        System.out.println("Running Search In Sorted Infinite");
        int[][] input = new int[][]{{4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30}, {16},
                {4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30}, {11},
                {1, 3, 8, 10, 15}, {15}, {1, 3, 8, 10, 15}, {200}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Key: " + input[i+1][0]);
            System.out.println("Output: "+ this.search(input[i], input[i+1][0]));
        }
    }

    class ArrayReader {
        int[] arr;

        ArrayReader(int[] arr) {
            this.arr = arr;
        }

        public int get(int index) {
            if (index >= arr.length)
                return Integer.MAX_VALUE;
            return arr[index];
        }
    }

    private int search(int[] arr, int key) {
        ArrayReader arrayReader = new ArrayReader(arr);
        int start, end;
        start = 0;
        end = 1;
        // No need to find the exact end of the arr. Find the position greater than the key
        while (arrayReader.get(end) < key) {
            int temp = end + 1;
            end = end + (end - start + 1) * 2; // double the range between start and end
            start = temp; // move the start old ending position
        }
        return this.binarySearch(arrayReader, start, end, key);
    }

    private int binarySearch(ArrayReader arrayReader, int start, int end, int key) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arrayReader.get(mid)== key) return mid;
            if (arrayReader.get(mid) > key) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }
}
