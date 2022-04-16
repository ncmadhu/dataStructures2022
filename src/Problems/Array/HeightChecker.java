package Problems.Array;

import Common.Problem;

import java.util.Arrays;

public class HeightChecker extends Problem {
    @Override
    public void run() {
        System.out.println("Running Height Checker");
        int[] nums;
        nums = new int[]{1,1,4,2,1,3};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.heightChecker(nums));
        nums = new int[]{5,1,2,3,4};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.heightChecker(nums));
        nums = new int[]{1,2,3,4,5};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.heightChecker(nums));

    }

    public int heightChecker(int[] heights) {
        int count = 0;
        int length =  heights.length;
        int[] expected = new int[length];
        for (int i = 0; i < length; i++) {
            expected[i] = heights[i];
        }
        Arrays.sort(expected);
        for (int i = 0; i < length; i++) {
            if (expected[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }
}
