package Problems.Array;

import Common.Problem;

import java.util.Arrays;

public class FindNumbersWithEvenNumberOfDigits extends Problem {

    @Override
    public void run() {
        System.out.println("Running Find Numbers With Even Number Of Digits");
        int[] nums;
        nums = new int[]{12,345,2,6,7896};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + this.findNumbers(nums));
        nums = new int[]{555,901,482,1771};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + this.findNumbers(nums));
    }

    public int findNumbers(int[] nums) {
        int evenCount = 0;
        for (int n: nums) {
            int digitCounter = 1;
            while (n >= 10) {
                n = n / 10;
                digitCounter++;
            }
            if (digitCounter % 2 == 0) {
                evenCount++;
            }
        }
        return evenCount;
    }
}
