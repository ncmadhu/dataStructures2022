package Problems.Searching;

import Common.Problem;

import java.util.Arrays;

public class SearchInsertPosition extends Problem {

    public int searchInsert(int[] nums, int target) {
        int mid, start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }

    @Override
    public void run() {
        System.out.println("Running SearchInsertPosition");
        int [] nums;
        int target;
        int index;
        nums = new int[]{1,2,3,4,5,6,7,8,9,10};
        target = 10;
        index = this.searchInsert(nums, target);
        System.out.println("Input : " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        System.out.println("Index is: " + index);
        nums = new int[]{1,2,3,4,5,6,7,8,9,10};
        target = 1;
        index = this.searchInsert(nums, target);
        System.out.println("Input : " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        System.out.println("Index is: " + index);
        nums = new int[]{1,2,3,4,5,6,7,8,9,10};
        target = 5;
        index = this.searchInsert(nums, target);
        System.out.println("Input : " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        System.out.println("Index is: " + index);
        nums = new int[]{1,2,3,4,5,6,7,8,9,10};
        target = 11;
        index = this.searchInsert(nums, target);
        System.out.println("Input : " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        System.out.println("Index is: " + index);
        nums = new int[]{1,2,3,4,5,6,7,8,9,10};
        target = 0;
        index = this.searchInsert(nums, target);
        System.out.println("Input : " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        System.out.println("Index is: " + index);
        nums = new int[]{1,2,3,4,5,7,8,9,10};
        target = 6;
        index = this.searchInsert(nums, target);
        System.out.println("Input : " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        System.out.println("Index is: " + index);
    }
}
