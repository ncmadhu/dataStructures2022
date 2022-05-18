package Problems.String;

import Common.Problem;

public class ReverseSentence extends Problem {
    @Override
    public void run() {
        System.out.println("Running Reverse Sentence");
        String[] input = new String[]{"Hello world.",
                "The quick brown fox jumped over the lazy dog."};
        this.execute(input);
    }

    private void execute(String[] input) {
        for (int i = 0; i < input.length; i++) {
            String sentence;
            sentence = input[i];
            System.out.println("Input: " + sentence);
            System.out.println("Output: " + this.reverseSentence(sentence));
        }
    }

    private String reverseSentence(String sentence) {
        String result = sentence;
        char[] chars = sentence.toCharArray();
        this.reverseString(chars, 0, chars.length - 1);
        for (int i = 0; i < chars.length; i++) {
            int start = i;
            while (i < chars.length && chars[i] != ' ') {
                i++;
            }
            this.reverseString(chars, start, i - 1);
        }
        return String.valueOf(chars);
    }

    private void reverseString(char[] chars, int start, int end) {
        int left = start;
        int right = end;
        while (left <= right) {
            char temp = chars[right];
            chars[right--] = chars[left];
            chars[left++] = temp;
        }
    }
}
