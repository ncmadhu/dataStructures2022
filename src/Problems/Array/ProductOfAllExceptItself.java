package Problems.Array;

import Common.Problem;

import java.util.Arrays;

public class ProductOfAllExceptItself extends Problem {
    @Override
    public void run() {
        System.out.println("Running Product of All Except Itself");
        int[] nums;
        nums =  new int[]{0,1,2};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(this.productOfAllExceptItself(nums)));
        nums =  new int[]{1,2,3,4};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(this.productOfAllExceptItself(nums)));
        nums =  new int[]{2,5,9,3,6};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(this.productOfAllExceptItself(nums)));
    }

    private int[] productOfAllExceptItself(int[] nums) {
        int length =  nums.length;
        int[] result = new int[length];
        // calculate product of all elements to the left side of the element
        int temp = 1;
        for (int i = 0; i < length; i++) {
            result[i] = temp;
            temp *= nums[i];
        }
        // Result array contains product of all elements to the left side of the element
        // calculate product of all elements to the right side of the element and
        // multiply with the current value of product of all elements to the left at the index
        temp = 1;
        for (int i = length - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }
        return result;
    }
}
