package Problems.Array;

import Common.Problem;

import java.util.Arrays;

public class MaxConsecutiveOnes extends Problem {
    @Override
    public void run() {
        System.out.println("Running Max Consecutive Ones");
        int[] nums;
        nums = new int[]{0,1,0,1,1};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + this.findMaxConsecutiveOnes(nums));
        nums = new int[]{1};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + this.findMaxConsecutiveOnes(nums));
        nums = new int[]{0,0,0,0,0};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + this.findMaxConsecutiveOnes(nums));
        nums = new int[]{0};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + this.findMaxConsecutiveOnes(nums));
        nums = new int[]{0,1};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + this.findMaxConsecutiveOnes(nums));
        nums = new int[]{1,0};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + this.findMaxConsecutiveOnes(nums));
        nums = new int[]{1,1};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + this.findMaxConsecutiveOnes(nums));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int prevCount = 0;
        int count = 0;
        for (int i: nums) {
            if (i == 1) {
                count++;
            } else {
                if (prevCount < count) {
                    prevCount = count;
                }
                count = 0;
            }
        }
        return (prevCount > count) ? prevCount: count;
    }
}
