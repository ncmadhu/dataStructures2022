package Problems.String;

import Common.Problem;
import org.apache.commons.lang3.StringUtils;

public class LongestCommonSubstringII extends Problem {
    @Override
    public void run() {
        System.out.println("Running Longest Common Substring II");
        String[] input = new String[]{"abdca", "cbda", "passport", "ppsspt", "adcadce", "bdaadce"};
        this.execute(input);
    }

    private void execute(String[] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            System.out.println("String 1: " + input[i]);
            System.out.println("String 2: " + input[i+1]);
            System.out.println("Bottom Up: " + this.longestCommonSubstringBottomUp(input[i], input[i+1]));
        }
    }

    private String longestCommonSubstringBottomUp(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 == 0 || len2 == 0) return StringUtils.EMPTY;
        int[] prev = new int[len2+1];
        int maxLength = 0;
        int lastIndex = 0;
        for (int i = 1; i <= len1; i++) {
            int[] mem = new int[len2+1];
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    mem[j] = 1 + prev[j-1];
                    if (mem[j] > maxLength) {
                        maxLength = mem[j];
                        lastIndex = j;
                    }
                } else {
                    mem[j] = 0;
                }
            }
            prev = mem;
        }
        return s2.substring(lastIndex - maxLength, lastIndex);
    }


}
