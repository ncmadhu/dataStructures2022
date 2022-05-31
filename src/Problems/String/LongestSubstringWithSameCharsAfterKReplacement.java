package Problems.String;

import Common.Problem;

import java.util.Arrays;
import java.util.HashMap;

public class LongestSubstringWithSameCharsAfterKReplacement extends Problem {

    @Override
    public void run() {
        System.out.println("Running Longest Substring With Same Characters After K Replacement");
        String[] input = new String[]{"aabccbb", "2", "abbcb", "1", "abccde", "1"};
        this.execute(input);
    }

    private void execute(String[] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            System.out.println("Input: " + input[i]);
            int k =  Integer.parseInt(input[i+1]);
            System.out.println("K: " + k);
            System.out.println("Output: " + this.longestSubstringWithSameCharactersAfterKReplacement(input[i], k));
        }
    }

     private int longestSubstringWithSameCharactersAfterKReplacement(String str, int k) {
        int length = str.length();
        if (length <= 1 || k >= length) return length;
        int maxFreq = 0;
        int maxLength = 0;
        int windowStart = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < length; windowEnd++) {
            char ch = str.charAt(windowEnd);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(ch));
            if (windowEnd - windowStart + 1 - maxFreq > k) {
                char leftCh =  str.charAt(windowStart);
                freqMap.put(leftCh, freqMap.get(leftCh) - 1);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

}
