package Problems.Array;

import Common.Problem;

import java.util.*;

public class SubSet extends Problem {
    @Override
    public void run() {
        System.out.println("Running SubSet");
        int[][] input = new int[][]{{1,3}, {1,5,3}, {1,3,3}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Output: " + this.findSubSets(input[i]));
            System.out.println("Output (With Out Duplicates): " + this.findSubSetsWithOutDuplicates(input[i]));
        }
    }

    private List<List<Integer>> findSubSets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        // Add empty list to the result
        result.add(new ArrayList<>());
        for (int i = 0; i < arr.length; i++) {
            List<List<Integer>> subset = new ArrayList<>();
            for (List item: result) {
                List<Integer> element = new ArrayList<>(item);
                element.add(arr[i]);
                subset.add(element);
            }
            result.addAll(subset);
        }
        return result;
    }

    private List<List<Integer>> findSubSetsWithOutDuplicates(int[] arr) {
        List<List<Integer>> subsets = new ArrayList<>();
        // Add empty list to the result
        subsets.add(new ArrayList<>());
        Set<Integer> unique = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int size = subsets.size();
            for (int n = 0; n < size; n++) {
                List<Integer> item = new ArrayList<>(subsets.get(n));
                item.add(arr[i]);
                int hashCode = item.hashCode();
                if (!unique.contains(hashCode)) {
                    unique.add(hashCode);
                    subsets.add(item);
                }
            }
        }
        return subsets;
    }
}
