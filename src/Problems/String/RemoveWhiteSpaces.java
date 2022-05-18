package Problems.String;

import Common.Problem;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class RemoveWhiteSpaces extends Problem {
    @Override
    public void run() {
        System.out.println("Running Remove White Spaces In String");
        String[] input = new String[]{"Running Remove White Spaces In String",
                " test ", "test      ", "       test", "NoSpace"};
        this.execute(input);
    }

    private void execute(String[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + input[i]);
            System.out.println("Output: " + this.removeWhiteSpaces(input[i].toCharArray()));
        }
    }

    private String removeWhiteSpaces(char[] input) {
        int length = input.length;
        if (length == 0) return StringUtils.EMPTY;
        int read, write;
        read = write = 0;
        while (read < length) {
            if (input[read] != ' ') {
                input[write++] = input[read];
            }
            read++;
        }
        return String.valueOf(Arrays.copyOfRange(input, 0, write));
    }
}
