package Problems.Array;

import Common.Problem;

import java.util.Arrays;

public class RemoveDuplicatesFromArray extends Problem {
    @Override
    public void run() {
        System.out.println("Running Remove Duplicates From Array");
        int[] nums;
        nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output 1: " + this.removeDuplicatesAlt(nums));
        System.out.println("Output 2: " + Arrays.toString(nums));
        nums = new int[]{1,1,2};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output 1: " + this.removeDuplicatesAlt(nums));
        System.out.println("Output 2: " + Arrays.toString(nums));
        nums = new int[]{1};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output 1: " + this.removeDuplicatesAlt(nums));
        System.out.println("Output 2: " + Arrays.toString(nums));
        nums = new int[]{1,1};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output 1: " + this.removeDuplicatesAlt(nums));
        System.out.println("Output 2: " + Arrays.toString(nums));

    }

    public int removeDuplicates(int[] nums) {
        int index = 1;
        int length = nums.length - 1;
        int i = 0;
        while (i < length) {
            int j = i + 1;
            while (j <= length && nums[i] == nums[j]) {
                j++;
            }
            if (j <= length) {
                nums[index] = nums[j];
                i = j;
                index++;
            } else {
                i = j;
            }
        }
        return index;
    }

    public int removeDuplicatesAlt(int[] nums) {
        int index = 1;
        int length = nums.length - 1;
        int i = 1;
        while (i <= length) {
            if ( nums[i] == nums[i - 1]) {
                i++;
            } else {
                nums[index] = nums[i];
                index++;
                i++;
            }
        }
        return index;
    }
}
