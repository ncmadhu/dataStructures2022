package Algorithms.Array;

import Algorithms.Algorithms;

import java.util.Arrays;

public class MoveZeroesToTheFront extends Algorithms {

    @Override
    public void run() {
        System.out.println("Running Move Zeroes To The Front");
        int[][] input = new int[][]{{1, 10, 20, 0, 59, 63, 0, 88, 0}, {0, 1, 10, 20, 0, 59, 63, 0, 88, 0},
                {0, 0, 0, 1, 10, 20, 59, 63, 88}, {1, 10, 20, 0, 59, 63, 0, 88, 0, 0, 0}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            //this.moveZeroes(input[i]);
            this.moveZeroesOptimum(input[i]);
            System.out.println("Output: " + Arrays.toString(input[i]));
        }
    }

    private void moveZeroes(int[] arr) {
        int length = arr.length;
        if (length == 0) return;
        int zeroPos = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] == 0) {
                int j = i;
                while (j > zeroPos) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = 0;
                zeroPos++;
            }
        }
    }
    private void moveZeroesOptimum(int[] arr) {
        int length =  arr.length;
        if (length == 0) return;
        int read, write;
        read = write = length - 1;
        while (read >= 0) {
            if (arr[read] != 0) {
                arr[write] = arr[read];
                write--;
            }
            read--;
        }
        for (int i = 0; i <= write; i++) {
            arr[i] = 0;
        }
    }
}
