package Problems.String;

import Common.Problem;
import org.apache.commons.lang3.StringUtils;

public class LongestPalindromicSubsequence extends Problem {
    @Override
    public void run() {
        System.out.println("Running Longest Palindromic Subsequence");
        String[] input = {"abdbca","cddpd", "abc", "aaaa"};
        this.execute(input);
    }

    private void execute(String[] input) {
        for (int i = 0; i < input.length; i++) {
            String text = input[i];
            System.out.println("Input: " + text);
            System.out.println("Longest Palindromic Subsequence: " + this.longestPalindromicSubsequence(text));
            System.out.println("Longest Palindromic Subsequence With Memoization: " +
                    this.longestPalindromicSubsequenceWithMem(text));
        }
    }

    private int longestPalindromicSubsequence(String text) {
        int length = text.length();
        if (length < 2) return length;
        int subSeqLen = 0;
        for (int i = 0; i < length; i++) {
            int len = this.longestPalindromeSubsequenceLen(text, i, length-1);
            if (len == length) return length;
            subSeqLen = Math.max(subSeqLen, len);
        }
        return subSeqLen;
    }

    private int longestPalindromeSubsequenceLen(String text, int left, int right) {
        if (left == right) return 1;
        while (left < right) {
            if (text.charAt(left) == text.charAt(right)) {
                return 2 + this.longestPalindromeSubsequenceLen(text, left+1, right-1);
            } else {
                return this.longestPalindromeSubsequenceLen(text, left, right-1);
            }
        }
        return 0;
    }

    private int longestPalindromicSubsequenceWithMem(String text) {
        int length = text.length();
        if (length < 2) return length;
        int[][] mem = new int[length][length];
        return this.longestPalindromeSubsequenceLenWithMem(text, 0, length-1, mem);
    }

    private int longestPalindromeSubsequenceLenWithMem(String text, int left, int right, int[][] mem) {
        if (mem[left][right] != 0) return mem[left][right];
        int len = 0;
        if (left == right) {
            len = 1;
        } else if (left < right) {
            if (text.charAt(left) == text.charAt(right)) {
                len = 2 + this.longestPalindromeSubsequenceLenWithMem(text, left+1, right-1, mem);
            } else {
                int len1 = this.longestPalindromeSubsequenceLenWithMem(text, left, right-1, mem);
                int len2 = this.longestPalindromeSubsequenceLenWithMem(text, left+1, right, mem);
                len = Math.max(len1,len2);
            }
        }
        mem[left][right] = len;
        return len;
    }


}
