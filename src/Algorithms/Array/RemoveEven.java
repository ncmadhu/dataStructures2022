package Algorithms.Array;

import Algorithms.Algorithms;

import java.util.Arrays;

public class RemoveEven extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Remove Even");
        int[] nums;
        nums =  new int[]{13,19,9,5,12,8,7,4,21,2,6,11};
        System.out.println(("Input: " + Arrays.toString(nums)));
        this.removeEven(nums);
        System.out.println(("Output: " + Arrays.toString(nums)));
        System.out.println(("Output (Alternate): " + Arrays.toString(this.removeEvenAlternate(nums))));

    }

    public void removeEven(int[] arr) {
        int length =  arr.length;
        int insertPos = 0;
        for (int i = 0; i < length; i++) {
            while (i < length && arr[i] % 2 == 0) {
                i++;
            }
            if (i < length) {
                arr[insertPos] = arr[i];
                insertPos++;
            }
        }
        for (int i = insertPos; i < length; i++) {
            arr[i] = 0;
        }
    }

    public int[] removeEvenAlternate(int[] arr) {
        int length = arr.length;
        if (length == 0) return new int[0];

        int oddCount = 0;
        // count the odd elements in the array
        for (int  i = 0; i < length; i++) {
            if (arr[i] % 2 != 0) oddCount++;
        }

        // Init result array to the oddCount
        int[] oddArray = new int[oddCount];
        oddCount = 0;

        // Add odd elements to the result array
        for (int i = 0; i < length; i++) {
            if (arr[i] % 2 != 0) {
                oddArray[oddCount++] = arr[i];
            }
        }
        return oddArray;
    }
}
