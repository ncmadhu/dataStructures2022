package Algorithms.Array;

import Algorithms.Algorithms;

import java.util.*;

public class ThirdMaximumNumber extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Third Maximum Number");
        int[] nums;
        nums = new int[]{3,2,1};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.thirdMax(nums));
        nums = new int[]{3,1};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.thirdMax(nums));
        nums = new int[]{3,3};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.thirdMax(nums));
        nums = new int[]{3};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.thirdMax(nums));
        nums = new int[]{2,2,3,3,1};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.thirdMax(nums));
        nums = new int[]{1,1,2};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.thirdMax(nums));
    }

    public int thirdMax(int[] nums) {
        Set<Integer> maximums = new HashSet<>();
        for (int num: nums) {
            maximums.add(num);
            if (maximums.size() > 3) {
                maximums.remove(Collections.min(maximums));
            }
        }
        if (maximums.size() == 3) {
            return Collections.min(maximums);
        }
        return Collections.max(maximums);
    }
}
