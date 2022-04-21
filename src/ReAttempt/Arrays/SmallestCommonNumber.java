package ReAttempt.Arrays;

import Common.Problem;

import java.util.Arrays;

public class SmallestCommonNumber extends Problem {
    @Override
    public void run() {
        System.out.println("Running Smallest Common Number");
        int[][] input = new int[][]{{6, 7, 10, 25, 30, 63, 64}, {0, 4, 5, 6, 7, 8, 50},{1, 6, 10, 14},
                {1, 5, 6, 7, 17, 20}, {3, 4, 7, 9, 12, 16, 50}, {5, 6, 7, 10, 16, 25}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 3) {
            System.out.println("Input: ");
            System.out.println("Array 1: " + Arrays.toString(input[i]));
            System.out.println("Array 2: " + Arrays.toString(input[i + 1]));
            System.out.println("Array 3: " + Arrays.toString(input[i + 2]));
            System.out.println("Smallest Common Number: " + this.findSmallestCommonNumber(input[i],
                    input[i+1], input[i+2]));
        }

    }

    private int findSmallestCommonNumber(int[] arr1, int[] arr2, int[] arr3) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int len3 = arr3.length;

        int i, j, k;
        i = j = k = 0;
        while (i < len1 && j < len2 && k < len3) {
            if (arr1[i] == arr2[j] && arr1[i] == arr3[k]) return arr1[i];
            int max = Math.max(Math.max(arr1[i], arr2[j]), arr3[k]);
            while (i < len1 && arr1[i] < max) i++;
            while (j < len2 && arr2[j] < max) j++;
            while (k < len3 && arr3[k] < max) k++;
        }
        return -1;
    }

    private int findSmallestCommonNumberO(int[] arr1, int[] arr2, int[] arr3) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int len3 = arr3.length;
        int l1, l2, l3;
        l1 = l2 = l3 = 0;
        while (l1 < len1 && l2 < len2 && l3 < len3) {
            if (arr1[l1] == arr2[l2] && arr2[l2] == arr3[l3]) return arr1[l1];
            int max = Math.max(Math.max(arr1[l1], arr2[l2]), arr3[l3]);
            while (l1 < len1 && arr1[l1] < max) {
                l1++;
            }
            while (l2 < len2 && arr2[l2] < max) {
                l2++;
            }
            while (l3 < len3 && arr3[l3] < max) {
                l3++;
            }
        }
        return -1;
    }
}
