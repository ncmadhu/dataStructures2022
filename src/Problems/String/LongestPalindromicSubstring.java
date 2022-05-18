package Problems.String;

import Common.Problem;
import org.apache.commons.lang3.StringUtils;

public class LongestPalindromicSubstring extends Problem {
    @Override
    public void run() {
        System.out.println("Running Longest Palindromic Substring");
        String[] input = {"", "abc", "1010", "aaccbababcbc"};
        this.execute(input);
    }

    private void execute(String[] input) {
        for (int i = 0; i < input.length; i++) {
            String text = input[i];
            System.out.println("Input: " + text);
            System.out.println("Longest Palindromic Substring: " + this.longestPalindromicSubstringBetter(text));
        }
    }

    private String longestPalindromicSubstringBetter(String text) {
        int length = text.length();
        if (length == 0) return StringUtils.EMPTY;
        int start = 0;
        int end = 0;
        for (int i = 0; i < length; i++) {
            // Odd Palindrome
            int oddLen = this.getPalindromeLength(text, i-1, i+1);
            // Even Palindrome
            int evenLen = this.getPalindromeLength(text, i, i+1);
            int len = Math.max(oddLen, evenLen);
            if (len > end - start) {
                start = i - (len-1) / 2;
                end = i + len / 2;
            }
        }
        return text.substring(start, end+1);
    }

    private int getPalindromeLength(String text, int left, int right) {
        while (left >= 0 && right < text.length()) {
            if (text.charAt(left) != text.charAt(right)) break;
            left--;
            right++;
        }
        return right - left - 1;
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
            String palindrome = input.substring(left + 1, right);
            if (palindrome.length() > output.length()) {
                output = palindrome;
            }
            if (input.charAt(i-1) == input.charAt(i) && output.length() < 2) {
                output = input.substring(i-1, i+1);
            }
        }
        return output;
    }
}
