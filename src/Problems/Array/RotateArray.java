package Problems.Array;

import Common.Problem;

import java.util.Arrays;

public class RotateArray extends Problem {
    @Override
    public void run() {
        System.out.println("Running Rotate Array");
        int[] nums;
        int k;
        nums = new int[]{-1,-100,3,99};
        k = 2;
        System.out.println(("Input: " + Arrays.toString(nums)));
        this.rotateArray(nums,k);
        System.out.println("Output: " + Arrays.toString(nums));
        nums = new int[]{1,2,3,4,5,6,7};
        k = 3;
        System.out.println(("Input: " + Arrays.toString(nums)));
        this.rotateArray(nums,k);
        System.out.println("Output: " + Arrays.toString(nums));
    }

    public void rotateArray(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        if (k == 0) return;
        int swapped = 0;
        for (int start = 0; swapped < length; start++) {
            int curr = start;
            int prev = nums[curr];
            do {
                int next = (curr + k) % length;
                int temp = nums[next];
                nums[next] = prev;
                curr = next;
                prev = temp;
                swapped++;
            } while(curr != start);
        }
    }
}
