package Algorithms.ReAttempt1.Arrays;

import Algorithms.Algorithms;

import java.util.Arrays;
import java.util.HashSet;

public class FindTwoNumAddToN extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Find Two Numbers Add Upto N");
        int[] nums;
        int target;
        nums = new int[]{2,7,11,15};
        target = 9;
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println(("Target: " + target));
        System.out.println("Output: " + Arrays.toString(this.findSum(nums,target)));
        nums = new int[]{2,3,4};
        target = 6;
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println(("Target: " + target));
        System.out.println("Output: " + Arrays.toString(this.findSum(nums,target)));
        nums = new int[]{-1,0};
        target = -1;
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println(("Target: " + target));
        System.out.println("Output: " + Arrays.toString(this.findSum(nums,target)));
    }

    private int[] findSum(int[] nums, int target) {
        if (nums.length == 0) return nums;
        HashSet<Integer> otherNum = new HashSet<>();
        for(int n: nums) {
            if (otherNum.contains(target - n)) {
                return new int[]{target -n, n};
            } else {
                otherNum.add(n);
            }
        }
        return nums;
    }
}
