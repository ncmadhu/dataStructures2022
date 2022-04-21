package ReAttempt.Arrays;

import Common.Problem;

import java.util.Arrays;

public class ReArrangeMaxMin extends Problem {
    @Override
    public void run() {
        System.out.println("Running Re Arrange Max And Min");
        int[] nums;
        nums =  new int[]{1,2,3,4,5,6,7};
        System.out.println("Input: " + Arrays.toString(nums));
        this.reArrange(nums);
        System.out.println("Output: " + Arrays.toString(nums));
    }

    public void reArrange(int[] nums) {
        int length = nums.length;
        if (length == 0) return;
        int maxElem = nums[length - 1] + 1;
        int maxIdx = length - 1;
        int minIdx = 0;
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) nums[i] = nums[i] + (nums[maxIdx--] % maxElem) * maxElem;
            else nums[i] = nums[i] + (nums[minIdx++] % maxElem) * maxElem;
        }
        for (int i = 0; i < length; i++) {
            nums[i] = nums[i] / maxElem;
        }
    }
}
