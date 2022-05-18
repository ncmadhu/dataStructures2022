package Problems.String;

import Common.Problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak extends Problem {

    @Override
    public void run() {
        System.out.println("Running Word Break");
        String[] input = new String[]{"applepie",
                "applepear", "pierpie", "pierppie", "hellonow"};
        this.execute(input);
    }

    private void execute(String[] input) {
        Set<String> dictionary = new HashSet<>(Arrays.asList("apple", "pie", "pear", "pier", "hell",
                "hello", "on", "now"));
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + input[i]);
            System.out.println("Output: " + this.canSegmentString(input[i], dictionary));
        }
    }

    private boolean canSegmentStringNW(String input, Set<String> dictionary) {
        int length = input.length();
        if (length == 0) return false;
        StringBuffer sbr = new StringBuffer();
        int read = 0;
        boolean prevEnd = false;
        while (read < length) {
            sbr.append(input.charAt(read));
            if (dictionary.contains(sbr.toString())) {
                prevEnd = true;
            } else if (prevEnd) {
                sbr = new StringBuffer();
                sbr.append(input.charAt(read));
                prevEnd = false;
            }
            read++;
        }
        if (dictionary.contains(sbr.toString())) return true;
        return false;
    }

    private boolean canSegmentString(String input, Set<String> dictionary) {
        int length = input.length();
        if (length == 0) return false;
        for (int i = 0; i < input.length(); i++) {
            String firstWord = input.substring(0, i);
            if (dictionary.contains(firstWord)) {
                String secondWord = input.substring(i);
                if (secondWord.isEmpty()) return true;
                if (dictionary.contains(secondWord)) return true;
                if (canSegmentString(secondWord, dictionary)) return true;
            }
        }
        return false;
    }
}
