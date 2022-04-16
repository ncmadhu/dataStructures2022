package Problems.Sorting;

import Common.Problem;

import java.util.Arrays;

public class QuickSort extends Problem {
    @Override
    public void run() {
        System.out.println("Running Quick Sort");
        int[] nums;
        nums =  new int[]{13,19,9,5,12,8,7,4,21,2,6,11};
        System.out.println(("Input: " + Arrays.toString(nums)));
        this.quickSort(nums);
        System.out.println("Output: " + Arrays.toString(nums));
    }

    private void quickSort(int[] nums) {
        this.quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int p, int r) {
        if (p < r) {
            int pivot = this.partition(nums, p, r);
            this.quickSort(nums, p, pivot - 1);
            this.quickSort(nums, pivot + 1, r);
        }
    }

    private int partition(int[] nums, int p, int r) {
        int temp;
        int x = nums[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            // Move elements less than pivot element x to left
            if (nums[j] <= x) {
                i = i + 1;
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        // Move pivot element to middle such that left of pivot is <= x
        // and right of pivot is >= x
        temp = nums[i + 1];
        nums[i + 1] = x;
        nums[r] = temp;
        return i + 1;
    }
}
