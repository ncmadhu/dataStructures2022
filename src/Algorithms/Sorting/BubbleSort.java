package Algorithms.Sorting;

import Algorithms.Algorithms;

import java.util.Arrays;

public class BubbleSort extends Algorithms {

    public int[] bubbleSort(int[] nums) {
        // Compare adjacent elements and swap
        // O(n^2) complexity
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < length - 1 - i; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return nums;
    }

    @Override
    public void run() {
        System.out.println("Running Bubble Sort");
        int[] nums;
        nums =  new int[]{2,10,8,7};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + Arrays.toString(bubbleSort(nums)));
        nums =  new int[]{2,3,1,378,19,25};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + Arrays.toString(bubbleSort(nums)));
        nums =  new int[]{378,25,1,2,3,19};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + Arrays.toString(bubbleSort(nums)));

    }
}
