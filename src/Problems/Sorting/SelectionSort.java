package Problems.Sorting;

import Common.Problem;

import java.util.Arrays;

public class SelectionSort extends Problem {
    @Override
    public void run() {
        System.out.println("Running Selection Sort");
        int[] nums;
        nums =  new int[]{10,5,8,20,2,18};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + Arrays.toString(selectionSort(nums)));
        nums =  new int[]{11,25,12,22,64};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + Arrays.toString(selectionSort(nums)));
        nums =  new int[]{10,5,8,2,1};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + Arrays.toString(selectionSort(nums)));
    }

    private int[] selectionSort(int[] nums) {
        // Get minimum element index and swap at each pass of outer loop
        // O(n^2) complexity
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            int minIdx = i;
            for (int j = 1 + i; j < length; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            int swap = nums[minIdx];
            nums[minIdx]= nums[i];
            nums[i] = swap;
        }
        return nums;
    }
}
