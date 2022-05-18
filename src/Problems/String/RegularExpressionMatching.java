package Problems.String;

import Common.Problem;

public class RegularExpressionMatching extends Problem {
    @Override
    public void run() {
        System.out.println("Running Regular Expression Matching In String");
        String[] input = new String[]{"aabbbbbcdda", "a*bb*cdda", "aabbbbbcdda", "a*bb*.dda",
                                      "aabbbbbcdda", "aab*e*cd*a", "aabbbbbcdda", "a*b*c*d*a*",
                                      "aabbbbbcdda", ".*b*c*d*a*", "aabbbbbcdda", "aabbbbbcdda",
                                      "aabbbbbcdda", "aabbbbbcdd", "aabbbbbcdda", "a*b*c*da",
                                      "aaa", "a*a*a*"};
        this.execute(input);
    }

    private void execute(String[] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            System.out.println("Input: " + input[i]);
            System.out.println("Pattern: " + input[i+1]);
            System.out.println("Output: " + this.regExMatch(input[i], input[i+1]));
        }
    }

    private boolean regExMatch(String text, String pattern) {
        int textLen = text.length();
        int patternLen = pattern.length();
        if (textLen == 0 || patternLen == 0) return false;
        int t = 0;
        int p = 0;
        char prevCh = '\0';
        while (t < textLen && p < patternLen) {
            char textCh = text.charAt(t);
            char pattCh = pattern.charAt(p);
            if (textCh == pattCh) {
                prevCh = pattCh;
                t++;
                p++;
            }
            else if (pattCh == '.') {
                prevCh = textCh;
                t++;
                p++;
            } else if (pattCh == '*' && prevCh == textCh) {
                while (t < textLen - 1 && prevCh == textCh) {
                    textCh = text.charAt(++t);
                }
                p++;
            } else if (pattCh == '*' && prevCh == text.charAt(t-1)) {
                p++;
            } else if (p+1 < patternLen && pattern.charAt(p+1) == '*') {
                p += 2;
            } else {
                return false;
            }
        }
        if (t == textLen) return true;
        return false;
    }
}
