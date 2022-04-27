package ReAttempt.Sorting;

import Common.Problem;

import java.util.Arrays;

public class QuickSort extends Problem {
    @Override
    public void run() {
        System.out.println("Running QuickSort Re Attempt");
        int[][] input = new int[][]{{55, 23, 26, 2, 18, 78, 23, 8, 2, 3}, {1}, {9, 8, 7, 2, 3, 1},
                {10, 20, 30, -1, -2}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            //this.quickSort(input[i]);
            this.reAttempt(input[i]);
            System.out.println("Output: " + Arrays.toString(input[i]));
        }
    }

    private void reAttempt(int[] arr) {
        this.reAttempt(arr, 0, arr.length - 1);
    }

    private void reAttempt(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = this.reAttemptPartition(arr, low, high);
            this.reAttempt(arr, low, pivot - 1);
            this.reAttempt(arr, pivot + 1, high);
        }
    }

    private int reAttemptPartition(int[] arr, int low, int high) {
        int pivotValue = arr[low];
        int left = low;
        int right = high;
        while (left < right) {
            while (left <= high && arr[left] <= pivotValue) left++;
            while (arr[right] > pivotValue) right--;
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        // pivot --- lesser --- right --- greater --- left --- end
        // At this point arr[right] is <= pivotValue and arr[left] > pivotValue. Hence the swap
        // right --- lesser --- pivot --- greater --- left --- end
        arr[low] = arr[right];
        arr[right] = pivotValue;
        return right;
    }

    private void quickSort(int[] arr) {
        // Send to the recursive function with the arr, start and end
        this.quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = this.partitionAlt(arr, low, high);
            this.quickSort(arr, low, pivot - 1);
            this.quickSort(arr, pivot + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        // Take pivot value to compare against
        // Element lesser than pivot value goes to the left
        // Element greater than pivot value goes to the right
        int pivotValue = arr[low];
        int left = low;
        int right = high;
        while (left < right) {
            // increment left until an element greater than pivot value is found
            while (left <= high && arr[left] <= pivotValue) left++;
            // decrement right until an element lesser than pivot value is found
            // right cannot decrement beyond 0 because it will encounter pivot value and the loop will end there
            while (arr[right] > pivotValue) right--;
            // check whether right has not crossed left in a case of sorted array
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                //No need to update the left and right pointer after the swap
                //since arr[left] is now swapped with a lesser value than pivot, hence it will be incremented
                //when the arr[left] <= pivotValue is checked
                //similar for arr[right] which will be decremented since it has value greater than pivotValue
            }
        }
        //Above while loop would have stopped when the arr[right] <= pivotValue and left has crossed over right
        //and stopped at an element greater than pivotValue
        //Move pivot to the middle position such that left of pivot is lesser and right of pivot is greater
        arr[low] = arr[right];
        arr[right] = pivotValue;
        return right;
    }

    private int partitionAlt(int[] arr, int low, int high) {
        int pivotValue = arr[high];
        int i = high;
        int j = low;
        while (i > j) {
            // decrement i until an element lesser than pivot value is found
            while (i >= 0 && arr[i] >= pivotValue) i--;
            // increment j until an element greater than pivot value is found
            while (arr[j] < pivotValue) j++;
            if (i > j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[high] = arr[j];
        arr[j] = pivotValue;
        return j;
    }
}
