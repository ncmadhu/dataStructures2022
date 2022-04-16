package Problems.Array;

import Common.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.sort;

public class FindAllNumbersDisappearedInAnArray extends Problem {
    @Override
    public void run() {
        int[] nums;
        nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.findDisappearedNumbers(nums));
        nums = new int[]{1,1};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.findDisappearedNumbers(nums));
        nums = new int[]{2,2};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.findDisappearedNumbers(nums));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int newIndex = Math.abs(nums[i]) - 1;
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= length; i++) {
            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }
        return result;
    }
}
