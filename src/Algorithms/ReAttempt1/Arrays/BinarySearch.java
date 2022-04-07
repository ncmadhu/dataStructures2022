package Algorithms.ReAttempt1.Arrays;

import Algorithms.Algorithms;

import java.util.Arrays;

public class BinarySearch extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Binary Search");
        int target;
        int[] nums;
        nums = new int[]{1,3,9,10,12};
        target = 9;
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output (Iterative): " + this.binarySearchIterative(nums, target));
        System.out.println("Output (Recursive): " + this.binarySearchRecursive(nums, target));
        nums = new int[]{-1,3,9,10,12};
        target = -1;
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output (Iterative): " + this.binarySearchIterative(nums, target));
        System.out.println("Output (Recursive): " + this.binarySearchRecursive(nums, target));
        nums = new int[]{-1,3,9,10,12};
        target = 12;
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output (Iterative): " + this.binarySearchIterative(nums, target));
        System.out.println("Output (Recursive): " + this.binarySearchRecursive(nums, target));
        nums = new int[]{-1,3,10,12};
        target = 11;
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output (Iterative): " + this.binarySearchIterative(nums, target));
        System.out.println("Output (Recursive): " + this.binarySearchRecursive(nums, target));
        nums = new int[]{-1,3,10,12};
        target = 10;
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output (Iterative): " + this.binarySearchIterative(nums, target));
        System.out.println("Output (Recursive): " + this.binarySearchRecursive(nums, target));
    }

    private int binarySearchIterative(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) return -1;
        int start = 0;
        int end = length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2; // Avoiding overflow error
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) start = mid + 1;
            if (nums[mid] > target) end = mid - 1;
        }
        return -1;
    }

    private int binarySearchRecursive(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) return -1;
        return this.binarySearchRecursiveHelper(nums, 0, length-1, target);
    }

    private int binarySearchRecursiveHelper(int[] nums, int start, int end, int target) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2; // Avoiding overflow error
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return this.binarySearchRecursiveHelper(nums, mid + 1, end, target);
        } else {
            return this.binarySearchRecursiveHelper(nums, start, mid - 1, target);
        }
    }
}
