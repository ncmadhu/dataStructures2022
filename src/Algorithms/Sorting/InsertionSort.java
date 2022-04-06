package Algorithms.Sorting;

import Algorithms.Algorithms;

import java.util.Arrays;

public class InsertionSort extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Insertion Sort");
        int[] nums;
        nums =  new int[]{20,5,40,60,10,30};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + Arrays.toString(insertionSort(nums)));
        nums =  new int[]{10,5,8,20,2,18};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + Arrays.toString(insertionSort(nums)));
        nums =  new int[]{11,25,12,22,64};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + Arrays.toString(insertionSort(nums)));
        nums =  new int[]{10,5,8,2,1};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + Arrays.toString(insertionSort(nums)));
    }

    public int[] insertionSort(int[] nums) {
        int length = nums.length;
        for(int i = 1; i < length; i++) {
            int curr = nums[i];
            int j = i - 1; // Init with element left to curr
            // As elements move to right jth position remains
            // empty to copy curr element at the end
            while(j >= 0 && nums[j] > curr) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = curr; // j = i - 1 Hence i - 1 + 1 = i if no element is greater than curr on the left side
        }
        return nums;
    }
}
