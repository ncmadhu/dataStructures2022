package Algorithms.Array;

import Algorithms.Algorithms;

import java.util.Arrays;

public class CheckIfNAndItsDoubleExist extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Check If N And Its Double Exist");
        int[] nums;
        nums = new int[]{10,2,5,3};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.checkIfExist(nums));
        nums = new int[]{5,2,10,3};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.checkIfExist(nums));
        nums = new int[]{};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.checkIfExist(nums));
        nums = new int[]{2};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + this.checkIfExist(nums));

    }

    public boolean checkIfExist(int[] arr) {
        boolean exist = false;
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[i] == arr[j] * 2 || arr[j] == arr[i] * 2) {
                    return true;
                }
            }
        }
        return exist;
    }
}
