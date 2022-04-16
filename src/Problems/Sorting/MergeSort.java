package Problems.Sorting;

import Common.Problem;

import java.util.Arrays;

public class MergeSort extends Problem {
    @Override
    public void run() {
        System.out.println("Running Merge Sort");
        int[] nums;
        nums =  new int[]{10,5,8,20,2,18};
        System.out.println(("Input: " + Arrays.toString(nums)));
        this.mergeSort(nums);
        System.out.println("Output: " + Arrays.toString(nums));
        nums =  new int[]{3,41,52,26,38,57,9,49,50};
        System.out.println(("Input: " + Arrays.toString(nums)));
        this.mergeSort(nums);
        System.out.println("Output: " + Arrays.toString(nums));
    }

    private void mergeSort(int[] nums) {
        this.mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            this.mergeSort(nums, start, mid);
            this.mergeSort(nums, mid + 1, end);
            this.merge(nums, start, mid, end);
        }
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] l = new int[n1];
        int[] r = new int[n2];

        int i = 0;
        int j = 0;

        for ( ;i < n1; i++) {
            l[i] = nums[start + i];
        }

        for ( ;j < n2; j++) {
            r[j] = nums[mid + 1 + j];
        }

        i = 0;
        j = 0;
        int k = start;

        while (i < n1 && j < n2) {
            if (l[i] < r[j]) {
                nums[k] = l[i];
                i = i + 1;
            } else {
                nums[k] = r[j];
                j = j + 1;
            }
            k = k + 1;
        }

        while (i < n1) {
            nums[k] = l[i];
            i = i + 1;
            k = k + 1;
        }

        while (j < n2) {
            nums[k] = r[j];
            j = j + 1;
            k = k + 1;
        }
    }
}
