package Problems.String;

import Common.Problem;
import org.apache.commons.lang3.StringUtils;

public class LongestCommonSubSequence extends Problem {
    @Override
    public void run() {
        System.out.println("Running Longest Common SubSequence");
        String[] input = new String[]{"ZXVVYZW", "XKYKZPW", "passport", "ppsspt", "XZ", "ZX"};
        this.execute(input);
    }

    private void execute(String[] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            System.out.println("String 1: " + input[i]);
            System.out.println("String 2: " + input[i+1]);
            System.out.println("Longest SubSequence: " + this.longestCommonSubSequence(input[i], input[i+1]));
            System.out.println("Longest SubSequence O(n) Space: " + this.longestCommonSubSequenceAlt(input[i], input[i+1]));
        }
    }

    private int longestCommonSubSequence(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 == 0 || len2 == 0) return 0;
        int[][] mem = new int[len1+1][len2+1];
        int maxLength = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    mem[i][j] = 1 + mem[i - 1][j - 1];
                } else {
                    mem[i][j] = Math.max(mem[i][j - 1], mem[i - 1][j]);
                }
                maxLength = Math.max(maxLength, mem[i][j]);
            }
        }
        return maxLength;
    }

    private int longestCommonSubSequenceAlt(String s1, String s2) {
        // O(n) Space
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 == 0 || len2 == 0) return 0;
        int[] prev = new int[len2+1];
        int maxLength = 0;
        for (int i = 1; i <= len1; i++) {
            int[] mem = new int[len2+1];
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    mem[j] = 1 + prev[j - 1];
                } else {
                    mem[j] = Math.max(mem[j - 1], prev[j]);
                }
                maxLength = Math.max(maxLength, mem[j]);
            }
            prev = mem;
        }
        return maxLength;
    }


}
