package Algorithms.Array;

import Algorithms.Algorithms;

import java.util.Arrays;

public class ValidMountainArray extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Valid Mountain Array");
        int[] nums;
        nums = new int[]{0,3,2,1};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.validMountainArray(nums));
        nums = new int[]{0,3,3,1};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.validMountainArray(nums));
        nums = new int[]{0,1,1,0};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.validMountainArray(nums));
        nums = new int[]{0,2,3,4,5,2,1,0};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.validMountainArray(nums));
        nums = new int[]{0,2,3,3,5,2,1,0};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.validMountainArray(nums));
        nums = new int[]{3,5,5};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.validMountainArray(nums));
        nums = new int[]{0,1,2,3,4,5,6,7,8,9};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.validMountainArray(nums));

    }

    public boolean validMountainArray(int[] arr) {
        int length = arr.length;
        int i = 0;

        while(i + 1 < length && arr[i] < arr[i+1]) {
            i++;
        }

        // Peak cant be first or last
        if (i == 0 || i == length - 1) {
            return false;
        }

        while(i + 1 < length && arr[i] > arr[i+1]) {
            i++;
        }

        return i == length - 1;

    }
}
