package Problems.String;

import Common.Problem;

import java.util.Arrays;
import java.util.HashMap;

public class FruitBasket extends Problem {
    @Override
    public void run() {
        System.out.println("Running Fruit Basket");
        char[][] input = new char[][]{{'A', 'B', 'C', 'A', 'C'}, {'A', 'B', 'C', 'B', 'B', 'C'},
                {'A', 'B', 'C', 'B', 'B', 'D'}, {'A', 'B', 'C', 'C', 'D', 'D', 'C'}};
        this.execute(input);
    }

    private void execute(char[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Max Fruits (BF): " + this.findMaxFruitsBF(input[i]));
            System.out.println("Max Fruits (BS): " + this.longestSubstringWithKDistinctCharacters(input[i], 2));
            System.out.println("Max Fruits (TP): " + this.findMaxFruitsTwoPointer(input[i]));
        }
    }

    private int findMaxFruitsBF(char[] fruits) {
        int maxFruits = 0;
        int length = fruits.length;
        if (length < 3) return length;
        for (int i = 0; i < length-1; i++) {
            int count = 1;
            char fruitOne = fruits[i];
            char fruitTwo = '\0';
            int j = i + 1;
            for (; j < length; j++) {
                if (fruitTwo == '\0' && fruits[j] != fruitOne) fruitTwo = fruits[j];
                if (fruits[j] == fruitOne || fruits[j] == fruitTwo) {
                    count++;
                } else {
                    break;
                }
            }
            maxFruits = Math.max(maxFruits, count);
            if (j == length) break;
        }
        return maxFruits;
    }

    private int findMaxFruitsTwoPointer(char[] fruits) {
        // solution good for only three distinct characters
        int maxFruits = 0;
        int length = fruits.length;
        if (length < 3) return length;
        int i = 0;
        char fruitOne = fruits[0];
        char fruitTwo = '\0';
        int f1 = 0;
        int f2 = -1;
        while (i < length) {
            if (fruitTwo == '\0' && fruits[i] != fruitOne) {
                fruitTwo = fruits[i];
            } else if (fruits[i] != fruitOne && fruits[i] != fruitTwo) {
                fruitOne = fruits[i-1];
                fruitTwo = fruits[i];
                maxFruits = Math.max(maxFruits,i - f1);
                f1 = i-1;
            }
            i++;
        }
        maxFruits = Math.max(maxFruits,i - f1);
        return maxFruits;
    }

    private int longestSubstringWithKDistinctCharacters(char[] chars, int k) {
        int length = chars.length;
        if (length <= k) return length;
        int maxLength = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < length; windowEnd++) {
            // Add every character to the freqMap and increase its count
            freqMap.put(chars[windowEnd], freqMap.getOrDefault(chars[windowEnd], 0) + 1);
            // If there are more than K distinct characters we need to remove the characters to bring it under k
            while (freqMap.size() > k) {
                // Reduce the count for character at window start
                freqMap.put(chars[windowStart], freqMap.get(chars[windowStart]) - 1);
                // If the windowStart character is not present anymore its value will be zero
                // If value is not zero the windowStart character is occurring somewhere in the middle also
                if (freqMap.get(chars[windowStart]) == 0) {
                    freqMap.remove(chars[windowStart]);
                }
                // Move the windowStart pointer
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
