package Problems.HashTables;

import Common.Problem;

import java.util.Arrays;
import java.util.HashSet;

public class FindArraysAreDisjoint extends Problem {
    @Override
    public void run() {
        System.out.println("Running Find Arrays Are Disjoint");
        int[] arr1, arr2;
        arr1 = new int[]{9,4,7,1,-2,6,5};
        arr2 = new int[]{7,1,-2};
        System.out.println("Array 1:" + Arrays.toString(arr1));
        System.out.println("Array 2:" + Arrays.toString(arr2));
        System.out.println("Is Disjoint: " + this.isDisjoint(arr1, arr2));
        arr1 = new int[]{9,4,7,1,-2,6,5};
        arr2 = new int[]{10,11,-12};
        System.out.println("Array 1:" + Arrays.toString(arr1));
        System.out.println("Array 2:" + Arrays.toString(arr2));
        System.out.println("Is Disjoint: " + this.isDisjoint(arr1, arr2));
    }

    private boolean isDisjoint(int[] arr1, int[] arr2) {
        if (arr1.length == 0 || arr2.length == 0) return true;
        HashSet<Integer> arrHset = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            arrHset.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            if (arrHset.contains(arr2[i])) return false;
        }
        return true;
    }
}
