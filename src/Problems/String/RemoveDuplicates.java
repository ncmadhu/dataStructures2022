package Problems.String;

import Common.Problem;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicates extends Problem {
    @Override
    public void run() {
        System.out.println("Running Remove Duplicates In String");
        String[] input = new String[]{"abbabcddbabcdeedebc",
                "aaaaaaaaa", "eaaaaaa", "aaaaaaaw"};
        this.execute(input);
    }

    private void execute(String[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + input[i]);
            System.out.println("Output: " + this.removeDuplicates(input[i].toCharArray()));
            System.out.println("Output (Two Pointer): " + this.removeDuplicatesTwoPointer(input[i].toCharArray()));
        }
    }

    private String removeDuplicates(char[] chars) {
        StringBuffer sbr = new StringBuffer();
        int length = chars.length;
        if (length == 0) return sbr.toString();
        HashSet<Character> present = new HashSet<>();
        for (int i = 0; i < length; i++) {
            char ch = chars[i];
            if (!present.contains(ch)) {
                present.add(ch);
                sbr.append(ch);
            }
        }
        return sbr.toString();
    }

    private String removeDuplicatesTwoPointer(char[] chars) {
        int length = chars.length;
        if (length == 0) return StringUtils.EMPTY;
        HashSet<Character> visited = new HashSet<>();
        int read, write;
        read = write = 0;
        while (read < length) {
            if (!visited.contains(chars[read])) {
                visited.add(chars[read]);
                chars[write++] = chars[read];
            }
            read++;
        }
        return String.valueOf(Arrays.copyOfRange(chars, 0, write));
    }
}
