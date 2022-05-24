package Problems.String;

import Common.Problem;

public class MinDeletionsToMakePalindrome extends Problem {
    @Override
    public void run() {
        System.out.println("Running Minimum Deletions To Make Palindrome");
        String[] input = new String[]{"abdbca", "cddpd", "pqr"};
        this.execute(input);
    }

    private void execute(String[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + input[i]);
            System.out.println("Min Deletions: " + this.findMinimumDeletions(input[i]));
            System.out.println("Min Deletions (Bottom Up): " + this.findMinimumDeletionsBottumUp(input[i]));
        }
    }

    private int findMinimumDeletions(String s) {
        int length = s.length();
        if (length < 2) return 0;
        return this.findMinimumDeletions(s, 0, length-1);
    }

    private int findMinimumDeletions(String s, int left, int right) {
        if (left == right) return 0;
        if (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                return 0 + this.findMinimumDeletions(s, left+1, right-1);
            } else {
                int del1 = 1 + this.findMinimumDeletions(s, left, right-1);
                int del2 = 1 + this.findMinimumDeletions(s, left+1, right);
                return Math.min(del1, del2);
            }
        }
        return 0;
    }

    private int findMinimumDeletionsBottumUp(String s) {
        int length = s.length();
        if (length < 2) return 0;
        int[][] mem = new int[length][length];
        for (int i = 0; i < length; i++) {
            mem[i][i] = 1;
        }
        // Bottom Up Approach
        // we analyze from the end like this [0 ...[n-2[n-1[n -n]]
        for (int start = length - 1; start >= 0; start--) {
            for (int end = start+1; end < length; end++) {
                if (s.charAt(start) == s.charAt(end)) {
                    mem[start][end] = 2 + mem[start + 1][end - 1];
                } else {
                    mem[start][end] = Math.max(mem[start+1][end], mem[start][end-1]);
                }
            }
        }
        return length - mem[0][length-1];
    }
}
