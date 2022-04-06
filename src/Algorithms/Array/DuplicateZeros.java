package Algorithms.Array;

import Algorithms.Algorithms;

import java.util.Arrays;

public class DuplicateZeros extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Duplicate Zeros");
        int[] nums;
        nums = new int[]{1,0,2,3,0,4,5,0};
        System.out.println("Input: " + Arrays.toString(nums));
        this.duplicateZeros(nums);
        System.out.println("Output: " + Arrays.toString(nums));
        nums = new int[]{0,0,2,3,0,4,5,0};
        System.out.println("Input: " + Arrays.toString(nums));
        this.oOfNSolution(nums);
        System.out.println("Output: " + Arrays.toString(nums));
        nums = new int[]{1,0,2,3,0,4,5,0,0};
        System.out.println("Input: " + Arrays.toString(nums));
        this.oOfNSolution(nums);
        System.out.println("Output: " + Arrays.toString(nums));
        nums = new int[]{0,0,0,0,0,0,0};
        System.out.println("Input: " + Arrays.toString(nums));
        this.oOfNSolution(nums);
        System.out.println("Output: " + Arrays.toString(nums));
        nums = new int[]{8,4,5,0,0,0,0,7};
        System.out.println("Input: " + Arrays.toString(nums));
        this.oOfNSolution(nums);
        System.out.println("Output: " + Arrays.toString(nums));
    }

    public void duplicateZeros(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (arr[i] == 0) {
                int j = length - 2;
                while (j > i) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                i++;
                if (i < length) {
                    arr[i] = 0;
                }
            }
        }
    }

    public void oOfNSolution(int[] arr) {
        int possibleDups = 0;
        int length = arr.length - 1;

        // Find possible duplicate count
        for (int i = 0; i <= length - possibleDups; i++) {
            if (arr[i] == 0) {
                // Edge case of zero at the end
                if ( i == length - possibleDups) {
                    arr[length] = 0;
                    length -= 1;
                    break;
                }
                possibleDups++;
            }
        }

        int copyFrom = length - possibleDups;
        for (int i = copyFrom; i >= 0; i--) {
            arr[i + possibleDups] = arr[i];
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups -= 1;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
    }
}
