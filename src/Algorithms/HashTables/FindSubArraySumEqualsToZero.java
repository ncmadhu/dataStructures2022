package Algorithms.HashTables;

import Algorithms.Algorithms;

import java.util.Arrays;
import java.util.HashMap;

public class FindSubArraySumEqualsToZero extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Find Sub Array Sum Equals To Zero");
        int[] arr;
        arr = new int[] {6, 4, -7, 3, 12, 9};
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Sub Array With Sum Zero Exists: " + this.findSubArrayWithSumZero(arr));
        arr = new int[] {6, 4, 7, 3, 12, 9};
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Sub Array With Sum Zero Exists: " + this.findSubArrayWithSumZero(arr));
    }

    // Traverse the array
    // Use HashMap to store sum as key and index i as value.
    // arr[i] == 0 or sum == 0 or HashMap already contains the sum return true
    // arr[i] == 0 -- element itself can be a zero which satisfies the condition
    // sum == 0 -- subsequent elements are opposite of each other
    // HashMap already contains the Key -- this condition occurs when the elements added after this item has
    // summed to zero --> x , y, z, i , j where y + z = 0 ****** important condition *****
    // If you completely traverse the array and have not found any of the above three
    // conditions then simply return false.
    private boolean findSubArrayWithSumZero(int[] arr) {
        HashMap < Integer,Integer > hMap = new HashMap < >();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] == 0 || sum == 0 || hMap.get(sum) != null) return true;
            hMap.put(sum, i);
        }
        return false;
    }
}
