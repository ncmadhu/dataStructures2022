package Problems.String;

import Common.Problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class StringPermutationByChangingCase extends Problem {
    @Override
    public void run() {
        System.out.println("Running String Permutation By Changing Case");
        String[] input = new String[]{"ad52", "ab7c", "abcd"};
        this.execute(input);
    }

    private void execute(String[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + input[i]);
            System.out.println("Permutations: " + this.permutateByCase(input[i]));
            System.out.println("Permutations (BS): " + this.permutateByCaseBS(input[i]));
        }
    }

    private HashSet<String> permutateByCase(String str) {
        HashSet<String> permutations = new HashSet<>();
        int length = str.length();
        if (length == 0) return permutations;
        permutateByCase(str.toCharArray(), 0, permutations);
        return permutations;
    }

    private void permutateByCase(char[] str, int curr, HashSet<String> permutations) {
        if (curr == str.length) return;
        permutations.add(String.valueOf(str));
        permutateByCase(str, curr + 1, permutations);
        str[curr] = Character.toUpperCase(str[curr]);
        permutations.add(String.valueOf(str));
        permutateByCase(str, curr + 1, permutations);
        str[curr] = Character.toLowerCase(str[curr]);
        return;
    }

    private List<String> permutateByCaseBS(String str) {
        List<String> permutations = new ArrayList<>();
        int length = str.length();
        if (length == 0) return permutations;
        // Init the list with the original string
        permutations.add(str);
        // Since character position is not changed. we run for the length of the string and process each character
        // in each iteration
        for (int i = 0; i < length; i++) {
            // Process only if it is a character
            if (Character.isLetter(str.charAt(i))) {
                int n = permutations.size();
                // Process for the current strings in the list
                for (int j = 0; j < n; j++) {

                    char[] chs = permutations.get(j).toCharArray();
                    if (Character.isUpperCase(chs[i])) {
                        chs[i] = Character.toLowerCase(chs[i]);
                    } else {
                        chs[i] = Character.toUpperCase(chs[i]);
                    }
                    permutations.add(String.valueOf(chs));
                }
            }
        }
        return permutations;
    }
}
