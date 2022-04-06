package Algorithms.HashTables;

import Algorithms.Algorithms;

import java.util.Arrays;
import java.util.HashMap;

public class FindFirstNonRepeatingInteger extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running First Non Repeating Integer In Array");
        int[] arr;
        arr = new int[]{9, 2, 3, 2, 6, 6};
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("First Non Repeating Integer: " + this.findFirstUnique(arr));
        arr = new int[]{4,5,1,2,0,4};
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("First Non Repeating Integer: " + this.findFirstUnique(arr));
    }

    private int findFirstUnique(int[] arr) {
        HashMap<Integer,Integer> occCount = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            occCount.put(arr[i], occCount.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            if (occCount.get(arr[i]) == 1) return arr[i];
        }
        return -1;
    }
}
