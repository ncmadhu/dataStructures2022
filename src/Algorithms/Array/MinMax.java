package Algorithms.Array;

import Algorithms.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinMax extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Min Max");
        int[] nums;
        nums =  new int[]{13,19,9,5,12,8,7,4,21,2,6,11};
        System.out.println(("Input: " + Arrays.toString(nums)));
        List<Integer> result = this.findMinMax(nums);
        System.out.println("Min: " + result.get(0));
        System.out.println("Max: " + result.get(1));
    }

    private List<Integer> findMinMax(int[] nums) {
        int i, currMin, currMax;
        List<Integer> minMax = new ArrayList<>();
        int length = nums.length;
        if (length / 2 == 0) {
            i = 2;
            if (nums[0] < nums[1]) {
                currMin = nums[0];
                currMax = nums[1];
            } else {
                currMin = nums[1];
                currMax = nums[0];
            }
        } else {
            i = 1;
            currMax = currMin = nums[0];
        }

        for (; i < length - 2; i++) {
            int smaller, larger;
            if (nums[i] < nums[i+1]) {
                smaller = nums[i];
                larger = nums[i+1];
            } else {
                smaller = nums[i+1];
                larger = nums[i];
            }

            if (currMin > smaller) {
                currMin = smaller;
            }

            if (currMax < larger) {
                currMax = larger;
            }
        }
        minMax.add(currMin);
        minMax.add(currMax);
        return minMax;
    }
}
