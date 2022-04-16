package Problems.Array;

import Common.Problem;

import java.util.Arrays;

public class ThreeSumSmaller extends Problem {
    @Override
    public void run() {
        System.out.println("Running Three Sum Smaller");
        int[] nums;
        int target;
        nums =  new int[]{-2,0,1,3};
        target = 2;
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Brute Force: " + this.threeSumSmallerBruteForce(nums, target));
        System.out.println("TwoSumSmaller + Binary Search: " + this.threeSumSmallerBinarySearch(nums, target));
        System.out.println("TwoSumSmaller + Two Pointer: " + this.threeSumSmallerTwoPointer(nums, target));
        nums =  new int[]{3,5,2,8,1};
        target = 7;
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Brute Force: " + this.threeSumSmallerBruteForce(nums, target));
        System.out.println("TwoSumSmaller + Binary Search: " + this.threeSumSmallerBinarySearch(nums, target));
        System.out.println("TwoSumSmaller + Two Pointer: " + this.threeSumSmallerTwoPointer(nums, target));
    }

    public int threeSumSmallerBruteForce(int[] nums, int target) {
        int count = 0;
        int length = nums.length;

        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int k= j + 1; k < length; k++) {
                    if (nums[i] + nums[j] + nums[k] < target) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int threeSumSmallerBinarySearch(int[] nums, int target) {
        int count = 0;
        int length = nums.length;
        if (length == 0) return 0;
        // sort the array
        Arrays.sort(nums);
        //Convert problem to two sum problem by looping i with target - nums[i]
        for (int i = 0; i < length - 2; i++) {
            count += this.twoSumSmallerBinarySearch(nums, i +1,target - nums[i]);
        }
        return count;
    }

    public int twoSumSmallerBinarySearch(int[] nums, int startIndex, int target) {
        // Find right most index from start index such that all index between
        // start index and right index satisfies nums[(startIndex <= rightIndex - 1)...] + nums[rightindex] < target
        int count = 0;
        int length = nums.length;
        for (int i = startIndex; i < length - 1; i++) {
            int rightMostIndex = this.binarySearch(nums, i, target - nums[i]);
            count += rightMostIndex - i;

        }
        return count;
    }

    public int binarySearch(int[] nums, int startIndex, int target) {
        int left = startIndex;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int threeSumSmallerTwoPointer(int[] nums, int target) {
        int count = 0;
        int length = nums.length;
        if (length == 0) return 0;
        Arrays.sort(nums);
        // Convert problem to twoSumSmaller
        for (int i = 0; i < length - 2; i++) {
            count += this.twoSumSmallerTwoPointer(nums, i+1, target - nums[i]);
        }
        return count;
    }

    public int twoSumSmallerTwoPointer(int[] nums, int startIndex, int target) {
        int count = 0;
        int length = nums.length;
        int left = startIndex;
        int right = length - 1;

        while (left < right) {
            if (nums[left] + nums[right] < target) {
                // possible pairs between left and right are also smaller since array is sorted
                count += right - left;
                // advance left pointer
                left++;
            } else {
                // decrease right pointer since all possible pairs between left and right will be greater
                right--;
            }
        }
        return count;
    }
}
