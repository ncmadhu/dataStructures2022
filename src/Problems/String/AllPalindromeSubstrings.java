package Problems.String;

import Common.Problem;

import java.util.ArrayList;
import java.util.List;

public class AllPalindromeSubstrings extends Problem {
    @Override
    public void run() {
        System.out.println("Running All Palindrome Substring In String");
        String[] input = new String[]{"aabbbaa", "abcdef", "edfghaahgfde"};
        this.execute(input);
    }

    private void execute(String[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + input[i]);
            System.out.println("Output: " + this.findAllPalindromeSubstrings(input[i]));
            System.out.println("Output (BS): " + this.findAllPalindromeSubstringsBetterSolution(input[i]));
        }
    }

    private List<String> findAllPalindromeSubstrings(String input) {
        List<String> palindromes = new ArrayList<>();
        int length = input.length();
        if (length < 2) return palindromes;
        for (int start = 0; start < length - 1; start++) {
            for (int end = start + 1; end < length; end++) {
                this.getPalindromes(input, start, end, palindromes);
            }
        }
        return palindromes;
    }

    private void getPalindromes(String input, int start, int end, List<String> palindromes) {
        int left = start;
        int right = end;
        while (left <= right) {
            if (input.charAt(left++) != input.charAt(right--)) return;
        }
        palindromes.add(input.substring(start, end+1));
    }

    private List<String> findAllPalindromeSubstringsBetterSolution(String input) {
        List<String> palindromes = new ArrayList<>();
        int length = input.length();
        if (length < 2) return palindromes;
        for (int i = 0; i < length; i++) {
            // Odd length Palindromes check
            this.getPalindromesBS(input, i-1, i+1, palindromes);
            // Even length Palindromes check
            this.getPalindromesBS(input, i, i+1, palindromes);
        }
        return palindromes;
    }

    private void getPalindromesBS(String input, int left, int right, List<String> palindromes) {
        while (left >= 0 && right < input.length()) {
            if (input.charAt(left) != input.charAt(right)) return;
            palindromes.add(input.substring(left, right+1));
            left--;
            right++;
        }
    }
}
