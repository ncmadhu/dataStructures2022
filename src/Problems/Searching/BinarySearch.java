package Problems.Searching;

import Common.Problem;

public class BinarySearch extends Problem {
    public int search(int[] nums, int target) {
        return this.binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        if (end < start) {
            return -1;
        }
        int mid = (start +  end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return this.binarySearch(nums, target, start, mid - 1);
        } else {
            return this.binarySearch(nums, target, mid + 1, end);
        }
    }

    private int alternateSolution(int[] nums, int target) {
        int mid, left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            mid = left + (right - left) / 2; // (left + right) / 2 causes overflow error when left +  right > 2 ^ 31 - 1. Maximum possible int value
            if (nums[mid] == target) return mid;
            if (target < nums[mid]) right = mid -1;
            else left = mid + 1;
        }
        return -1;
    }

    @Override
    public void run() {
        System.out.println("Running BinarySearch");
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10};
        int index = this.search(nums, 10);
        System.out.println("Index is: " + index);
        index =  this.alternateSolution(nums, 10);
        System.out.println("Index is: " + index);
    }
}
