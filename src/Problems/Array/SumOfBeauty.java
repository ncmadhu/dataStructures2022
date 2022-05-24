package Problems.Array;

import Common.Problem;

import java.util.Arrays;

public class SumOfBeauty extends Problem {
    @Override
    public void run() {
        System.out.println("Running Ceiling Of Number");
        int[][] input = new int[][]{{4,6,10},
                                    {2,4,6,4},
                                    { 8, 7, 6, 4, 1},
                                    { 2, 8, 3, 6, 10, 11}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Beauty Sum (BF): " + this.sumOfBeautiesBF(input[i]));
            System.out.println("Beauty Sum: " + this.sumOfBeauties(input[i]));
        }
    }
    private void prefixArray(int[] nums, int[] prefix) {
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = Math.max(nums[i-1], prefix[i-1]);
        }
    }

    private void suffixArray(int[] nums, int[] suffix) {
        int length = nums.length;
        suffix[length-1] = nums[length-1];
        for (int i = length-2; i >= 0; i--) {
            suffix[i] = Math.min(suffix[i+1], nums[i+1]);
        }
    }

    private int sumOfBeautiesBF(int[] nums) {
        int length = nums.length;
        int beautySum = 0;
        for (int i = 1; i < length-1; i++) {
            boolean allBeauty = true;
            int j = 0;
            while (allBeauty && j < i) {
                if (nums[j++] >= nums[i]) allBeauty = false;
            }
            j = i + 1;
            while (allBeauty && j < length) {
                if (nums[j++] <= nums[i]) allBeauty = false;
            }
            if (allBeauty) beautySum += 2;
            else if (nums[i-1] < nums[i] && nums[i] < nums[i+1]) beautySum += 1;
        }
        return beautySum;
    }

    private int sumOfBeauties(int[] nums) {
        int length = nums.length;
        int beautySum = 0;
        int[] prefix = new int[length];
        prefixArray(nums, prefix);
        int[] suffix = new int[length];
        suffixArray(nums, suffix);
        for (int i = 1; i < length - 1; i++) {
            if (prefix[i] < nums[i] && suffix[i] > nums[i]) beautySum += 2;
            else if (nums[i-1] < nums[i] && nums[i] < nums[i+1]) beautySum += 1;
        }
        return beautySum;
    }
}
