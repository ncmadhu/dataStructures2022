package Problems.String;

import Common.Problem;

import java.util.Arrays;
import java.util.HashMap;

public class LongestSubstringWithDistinctChars extends Problem {
    @Override
    public void run() {
        System.out.println("Running Longest Substring With Distinct Characters");
        String[] input = new String[]{"abcac", "acbdce", "abcbbd", "aabccbb", "abbbb", "abccde"};
        this.execute(input);
    }

    private void execute(String[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + input[i]);
            System.out.println("Output: " + this.longestSubstringWithDistinctCharacters(input[i]));
            System.out.println("Output (BS): " + this.longestSubstringWithDistinctCharactersAlt(input[i]));
        }
    }

     private int longestSubstringWithDistinctCharacters(String str) {
        int length = str.length();
        if (length <= 1) return length;
        int maxLength = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < length; windowEnd++) {
            freqMap.put(str.charAt(windowEnd), freqMap.getOrDefault(str.charAt(windowEnd), 0) + 1);
            while (freqMap.get(str.charAt(windowEnd)) > 1) {
                freqMap.put(str.charAt(windowStart), freqMap.get(str.charAt(windowStart)) - 1);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    private int longestSubstringWithDistinctCharactersAlt(String str) {
        int length = str.length();
        if (length <= 1) return length;
        int maxLength = 0;
        int windowStart = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < length; windowEnd++) {
            char ch = str.charAt(windowEnd);
            if (freqMap.containsKey(ch)) {
                // abcba ---> when we reach a windowStart will be 2 we cannot go back to 1
                // hence max(windowStart, 0 + 1)
                windowStart = Math.max(windowStart, freqMap.get(ch) + 1);
            }
            freqMap.put(ch, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
