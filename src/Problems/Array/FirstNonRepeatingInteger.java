package Problems.Array;

import Common.Problem;

import java.util.Arrays;
import java.util.HashMap;

public class FirstNonRepeatingInteger extends Problem {
    @Override
    public void run() {
        System.out.println("Running Product of All Except Itself");
        int[] nums;
        nums = new int[]{9,2,3,2,6,6};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.findFirstUnique(nums));
    }

    private int findFirstUnique(int[] nums) {
        if (nums.length == 0) return -1;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (countMap.get(nums[i]) == 1) return nums[i];
        }
        return -1;
    }
}
