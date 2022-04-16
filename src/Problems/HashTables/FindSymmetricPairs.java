package Problems.HashTables;

import Common.Problem;

import java.util.Arrays;
import java.util.HashMap;

public class FindSymmetricPairs extends Problem {
    @Override
    public void run() {
        System.out.println("Running Find Symmetric Pairs in Array");
        int[][] arr;
        arr = new int[][]{{1, 2}, {3, 4}, {5, 9}, {4, 3}, {9, 5}};
        System.out.println("Array :" + Arrays.toString(arr));
        System.out.println("Symmetric Pairs: " + findSymmetricPairs(arr));
        System.out.println("Symmetric Pairs (Better Solution): " + betterSolution(arr));
        arr = new int[][]{{1, 2}, {3, 4}, {3,6}, {5, 9}, {4, 3}, {6,3}, {9, 5}};
        System.out.println("Array :" + Arrays.toString(arr));
        System.out.println("Symmetric Pairs: " + findSymmetricPairs(arr));
        System.out.println("Symmetric Pairs (Better Solution): " + betterSolution(arr));
    }
    public int getHashCode(int one, int two) {
        return one * 10 + two;
    }
    private String findSymmetricPairs(int[][] arr) {
        String result = "";
        if (arr.length == 0) return result;
        HashMap<Integer, Integer> arrHmap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int[] value = arr[i];
            int hashCode = this.getHashCode(value[0], value[1]);
            arrHmap.put(hashCode, value[0] + value[1]);
        }
        for (int i = 0; i < arr.length; i++) {
            int[] value = arr[i];
            int hashCode = this.getHashCode(value[1], value[0]);
            if (arrHmap.containsKey(hashCode)) {
                result = result + "{" +value[0] + "," + value[1] + "}";
                int pairCode = this.getHashCode(value[0], value[1]);
                arrHmap.remove(pairCode);
            }
        }
        return result;
    }

    public String betterSolution(int[][] arr) {
        String result = "";
        if (arr.length == 0) return result;
        HashMap<Integer, Integer> arrHmap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int first = arr[i][0];
            int second = arr[i][1];
            Integer value = arrHmap.get(second);
            if (value != null && value == first) {
                result = result + "{" + second + "," + first + "}";
            } else {
                arrHmap.put(first, second);
            }
        }
        return result;
    }
}
