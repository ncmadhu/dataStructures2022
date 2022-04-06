package Algorithms.ReAttempt1.Arrays;

import Algorithms.Algorithms;

import java.util.Arrays;

public class RotateArray extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Rotate Array");
        int[] nums;
        int shift;
        nums = new int[]{1,2,3,4,5};
        shift = 1;
        System.out.println("Input: " + Arrays.toString(nums));
        this.rightRotateArray(nums, shift);
        System.out.println("Output Right Shift By (" + shift + "): " + Arrays.toString(nums));
        nums = new int[]{1,2,3,4,5};
        this.leftRotateArray(nums, shift);
        System.out.println("Output Left Shift By (" + shift + "): " + Arrays.toString(nums));
        nums = new int[]{1,2,3,4,5};
        shift = 3;
        System.out.println("Input: " + Arrays.toString(nums));
        this.rightRotateArray(nums, shift);
        System.out.println("Output Right Shift By (" + shift + "): " + Arrays.toString(nums));
        nums = new int[]{1,2,3,4,5};
        this.leftRotateArray(nums, shift);
        System.out.println("Output Left Shift By (" + shift + "): " + Arrays.toString(nums));
    }

    private void rightRotateArray(int[] nums, int shift) {
        int length = nums.length;
        if (length == 0 || length == shift) return;
        int shifted = 0; // Keep track of shifted elements
        for (int start = 0; shifted < length; start++) {
            int curr = start;
            int prev = nums[curr];
            do {
                int next = (curr + shift) % length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                curr = next;
                shifted++;
            } while(curr != start); // Run loop until start point is not reached again
        }
    }

    private void leftRotateArray(int[] nums, int shift) {
        int length = nums.length;;
        if (length == 0 || length == shift) return;
        int shifted = 0;
        for (int start = 0; shifted < length; start++) {
            int curr = start;
            int prev = nums[curr];
            do {
                int next = (length - shift + curr) % length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                curr = next;
                shifted++;
            } while (curr != start);
        }
    }
}
