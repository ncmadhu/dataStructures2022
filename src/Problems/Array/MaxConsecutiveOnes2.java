package Problems.Array;

import Common.Problem;

import java.util.Arrays;

public class MaxConsecutiveOnes2 extends Problem {
    @Override
    public void run() {
        System.out.println("Running Max Consecutive Ones II");
        int[] nums;
        nums = new int[]{1,0,1,1,0};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.findMaxConsecutiveOnes(nums));
        nums = new int[]{1,0,1,1,0,1};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.findMaxConsecutiveOnes(nums));
        nums = new int[]{1,0,1,1,1,1,0};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.findMaxConsecutiveOnes(nums));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int longestSeq = 0;
        int left = 0;
        int right = 0;
        int numZeroes = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                numZeroes++;
            }
            while (numZeroes == 2) {
                if (nums[left] == 0) {
                    numZeroes--;
                }
                left++;
            }
            longestSeq = Math.max(longestSeq, right - left + 1);
            right++;
        }
        return longestSeq;
    }
}
