package Problems.String;

import Common.Problem;

public class ReverseWordsInString extends Problem {
    @Override
    public void run() {
        System.out.println("Running Reverse Words In String");
        String input;
        input = "Let's take LeetCode contest";
        System.out.println("Input: " + input);
        System.out.println("Output: " + reverseWords(input));
        input = "Leet";
        System.out.println("Input: " + input);
        System.out.println("Output: " + reverseWords(input));
        input = "L";
        System.out.println("Input: " + input);
        System.out.println("Output: " + reverseWords(input));
        input = "God Ding";
        System.out.println("Input: " + input);
        System.out.println("Output: " + reverseWords(input));
    }

    public String reverseWords(String s) {

        char[] charArray = s.toCharArray();
        int length = charArray.length;
        int left = 0;
        int right = 0;
        while (right < length) {
            while(right < length && charArray[right] != ' ') {
                right++;
            }
            if ((right < length && charArray[right] == ' ') || right == length) {
                reverseString(charArray, left, right);
                right++;
                left = right;
            }
        }
        return new String(charArray);
    }

    public void reverseString(char[] s, int start, int end) {
        int mid = start + (end - start) / 2;
        for(int i=start, j = 0; i < mid; i++, j++) {
            char temp = s[i];
            s[i] = s[end - 1 - j];
            s[end - 1 - j] = temp;
        }
    }
}
