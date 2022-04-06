package Algorithms.Sorting;

import Algorithms.Algorithms;

import java.util.Arrays;

public class CountingSort extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Counting Sort");
        int[] nums;
        nums =  new int[]{13,19,9,5,12,8,7,4,21,2,6,11};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + Arrays.toString(this.countingSort(nums)));
    }

    private int[] countingSort(int[] nums) {
        int length = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        int[] count = new int[max + 1];
        int[] sorted = new int[length];
        // Count the occurrences of each element in num
        for (int i = 0; i < length; i++) {
           count[nums[i]] = count[nums[i]] + 1;
        }
        // Count the number of elements <= to element at i
        for (int i = 1; i < max + 1; i++) {
            count[i] = count[i] + count[i - 1];
        }
        for (int i = length - 1; i >=0; i--) {
            sorted[count[nums[i]] - 1] = nums[i];
            count[nums[i]] = count[nums[i]] - 1;
        }
        return sorted;
    }
}
