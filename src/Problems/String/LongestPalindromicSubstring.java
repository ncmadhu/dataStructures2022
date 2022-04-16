package Problems.String;

import Common.Problem;

public class LongestPalindromicSubstring extends Problem {
    @Override
    public void run() {
        System.out.println("Running Longest Palindromic Substring");
        String input;
        input = "bababc";
        System.out.println("Input: " + input);
        System.out.println("Longest Palindromic Substring: " + this.longestPalindromicSubstring(input));
        input = "bababcmalayalam";
        System.out.println("Input: " + input);
        System.out.println("Longest Palindromic Substring: " + this.longestPalindromicSubstring(input));
        input = "aacabdkacaa";
        System.out.println("Input: " + input);
        System.out.println("Longest Palindromic Substring: " + this.longestPalindromicSubstring(input));
    }

    private String longestPalindromicSubstringFail(String input) {
        // Third test does not pass :(
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            int start = i;
            int end = input.length() - 1;
            while (end >= start && input.charAt(end) != input.charAt(start)) {
                end--;
            }
            int left = start;
            int right = end;
            boolean palindrome = true;
            while (right >= left) {
                if (input.charAt(left) != input.charAt(right)) {
                    palindrome = false;
                    break;
                }
                left++;
                right--;
            }
            if (palindrome && end - start + 1 > output.length()) {
                output = input.substring(start, end + 1);
            }
        }
        return output;
    }

    public String longestPalindromicSubstring(String input) {
        String output = "";
        int length = input.length();
        for (int i = 1; i < length; i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < length) {
                if (input.charAt(left) != input.charAt(right)) {
                    break;
                }
                left--;
                right++;
            }
            String palindorme = input.substring(left + 1, right);
            if (palindorme.length() > output.length()) {
                output = palindorme;
            }
            if (input.charAt(i-1) == input.charAt(i) && output.length() < 2) {
                output = input.substring(i-1, i+1);
            }
        }
        return output;
    }
}
