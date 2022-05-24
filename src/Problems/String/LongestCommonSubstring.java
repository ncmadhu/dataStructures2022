package Problems.String;

import Common.Problem;

public class LongestCommonSubstring extends Problem {
    @Override
    public void run() {
        System.out.println("Running Longest Common Substring");
        String[] input = new String[]{"abdca", "cbda", "passport", "ppsspt", "adcadce", "bdaadce"};
        this.execute(input);
    }

    private void execute(String[] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            System.out.println("String 1: " + input[i]);
            System.out.println("String 2: " + input[i+1]);
            System.out.println("Brute Force: " + this.longestCommonSubstringBF(input[i], input[i+1]));
            System.out.println("Top Down: " + this.longestCommonSubstringTopDown(input[i], input[i+1]));
            System.out.println("Bottom Up: " + this.longestCommonSubstringBottomUp(input[i], input[i+1]));
        }
    }

    private int longestCommonSubstringBottomUp(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 == 0 || len2 == 0) return 0;
        // We only need previous row values to compare
        int[] prev = new int[len2+1];
        int maxLength = 0;
        for (int s1 = 1; s1 <= len1; s1++) {
            // Init the current row match values
            int[] mem = new int[len2+1];
            for (int s2 = 1; s2 <= len2; s2++) {
                if (str1.charAt(s1-1) == str2.charAt(s2-1)) {
                    // If a character matches, check whether the previous character in the second string
                    // also matched and update the value for current character
                    mem[s2] = 1 + prev[s2-1];
                    maxLength = Math.max(maxLength, mem[s2]);
                } else {
                    mem[s2] = 0;
                }
            }
            prev = mem;
        }
        return maxLength;
    }

    private int longestCommonSubstringBF(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 == 0 || len2 == 0) return 0;
        return longestCommonSubstringBF(str1, str2, 0, 0, 0);
    }

    private int longestCommonSubstringBF(String str1, String str2, int s1, int s2, int count) {
        if (s1 == str1.length() || s2 == str2.length()) return count;
        if (str1.charAt(s1) == str2.charAt(s2)) {
            count = this.longestCommonSubstringBF(str1,str2, s1+1, s2+1, 1 + count);
        }
        int c1 = this.longestCommonSubstringBF(str1, str2, s1, s2+1, 0);
        int c2 = this.longestCommonSubstringBF(str1, str2, s1+1, s2, 0);
        return Math.max(count, Math.max(c1,c2));
    }

    private int longestCommonSubstringTopDown(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 == 0 || len2 == 0) return 0;
        int len = Math.max(len1, len2);
        Integer[][][] mem = new Integer[len1][len2][len];
        return longestCommonSubstringTopDown(str1,str2, 0, 0, 0, mem);
    }

    private int longestCommonSubstringTopDown(String str1, String str2, int s1, int s2, int count, Integer[][][] mem) {
        if (s1 == str1.length() || s2 == str2.length()) return count; // Check any more characters left to process
        if (mem[s1][s2][count] != null) return mem[s1][s2][count]; // Check already computed
        int c1 = count;
        if (str1.charAt(s1) == str2.charAt(s2)) {
            c1 = this.longestCommonSubstringTopDown(str1,str2, s1+1, s2+1, count + 1, mem);
        }
        int c2 = this.longestCommonSubstringTopDown(str1,str2, s1, s2+1, 0, mem);
        int c3 = this.longestCommonSubstringTopDown(str1,str2, s1+1, s2, 0, mem);
        mem[s1][s2][count] = Math.max(c1, Math.max(c2, c3));
        return mem[s1][s2][count];
    }

    private int longestCommonSubstringFail(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len2 == 0 || len1 == 0) return 0;
        if (len2 > len1) {
            String temp1 = str2;
            str2 = str1;
            str1 = temp1;
            int temp2 = len2;
            len2 = len1;
            len1 = temp2;
        }
        int len = 0;
        for (int i = 0; i < len1; i++) {
            int j = 0;
            while (j < len2 && str2.charAt(j) != str1.charAt(i)) j++;
            if (j < len2) {
                int k = i;
                int start = j;
                while (j < len2 && k < len1 && str2.charAt(j) == str1.charAt(k)) {
                    j++;
                    k++;
                }
                System.out.println(str1.substring(i, k));
                len = Math.max(len, k - i);
            }
        }
        return len;
    }
}
