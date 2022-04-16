package Problems.Array;

import Common.Problem;

import java.util.Arrays;

public class RemoveElement extends Problem {
    @Override
    public void run() {
        System.out.println("Running Remove Elements");
        int[] nums;
        int val;
        nums = new int[]{0,1,2,2,3,0,4,2};
        val = 2;
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.removeElement(nums, val));
        nums = new int[]{3,2,2,3};
        val = 3;
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.removeElement(nums, val));
        nums = new int[]{3};
        val = 3;
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.removeElement(nums, val));
    }

    public int removeElement(int[] nums, int val) {
        int index = 0;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (nums[i] == val) {
                int j = i + 1;
                while (j < length && nums[j] == val) {
                    j++;
                }
                if (j < length) {
                    nums[index] = nums[j];
                    index++;
                    i = j;
                }
            } else {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
