package Problems.String;

import Common.Problem;

import java.util.Arrays;
import java.util.HashMap;

public class LongestSubstringWithKDistinctChar extends Problem {
    @Override
    public void run() {
        System.out.println("Running Longest Substring With k Distinct Characters");
        char[][] input = new char[][]{{'A', 'B', 'C', 'A', 'C'}, {'3'}, {'A', 'B', 'C', 'B', 'B', 'C'}, {'2'},
                {'A', 'B', 'C', 'B', 'B', 'D'}, {'1'}, {'A', 'B', 'C', 'C', 'D', 'D', 'C'}, {'2'}};
        this.execute(input);
    }

    private void execute(char[][] input) {
        for (int i = 0; i < input.length; i = i+2) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            int k =  Character.getNumericValue(input[i+1][0]);
            System.out.println("K: " + k);
            System.out.println("Output: " + this.longestSubstringWithKDistinctCharacters(input[i], k));
        }
    }

     private int longestSubstringWithKDistinctCharacters(char[] chars, int k) {
        int length = chars.length;
        if (length <= k) return length;
        int maxLength = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < length; windowEnd++) {
            freqMap.put(chars[windowEnd], freqMap.getOrDefault(chars[windowEnd], 0) + 1);
            while (freqMap.size() > k) {
                freqMap.put(chars[windowStart], freqMap.get(chars[windowStart]) - 1);
                if (freqMap.get(chars[windowStart]) == 0) {
                    freqMap.remove(chars[windowStart]);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
