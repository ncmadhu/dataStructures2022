package Problems.HashTables;

import Common.Problem;

import java.util.Arrays;
import java.util.HashMap;

public class FindTwoPairsofSameSum extends Problem {
    @Override
    public void run() {
        System.out.println("Running Find Two Pairs Of Sum a+b = c+d");
        int[] arr;
        arr = new int[]{3, 4, 7, 1, 12, 9};
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Two Pairs: " + this.findPairNonOptimal(arr));
        System.out.println("Two Pairs (Optimal): " + this.findPairsOptimal(arr));
    }

    private String findPairNonOptimal(int[] arr) {
        String result = "";
        int length = arr.length;
        for (int i = 0; i < length - 3; i++) {
            for (int j = i + 1; j < length - 2; j++) {
                for (int k = j + 1; k < length - 1; k++) {
                    for (int l = k + 1; l < length; l++) {
                        if (arr[i] + arr[j] == arr[k] + arr[l]) {
                            result = "{" + arr[i] + "," + arr[j] + "}{" + arr[k] + "," + arr[l] + "}";
                        }
                    }
                }
            }
        }
        return result;
    }

    // Store the sum as key and pairs as value
    // reduced from O(n ^ 4) to  O(n ^ 2)
    private String findPairsOptimal(int[] arr) {
        String result = "";
        HashMap<Integer, int[]> pairs = new HashMap<>();
        int length = arr.length;;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (pairs.containsKey(arr[i] + arr[j])) {
                    int[] values = pairs.get(arr[i] + arr[j]);
                    result = "{" + values[0] + "," + values[1] + "}{" + arr[i] + "," + arr[j] + "}";
                    return result;
                } else {
                    pairs.put(arr[i] + arr[j], new int[]{arr[i], arr[j]});
                }
            }
        }
        return result;
    }
}
