package Problems.String;

import Common.Problem;
import org.apache.commons.lang3.StringUtils;

public class DecodeString extends Problem {

    @Override
    public void run() {
        System.out.println("Running Decode String");
        String[] input = new String[]{"a2z2b4",
        "b10c100", "a0b0"};
        this.execute(input);
    }

    private void execute(String[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + input[i]);
            System.out.println("Output: " + this.decode(input[i]));
        }
    }

    private String decode(String input) {
        int length = input.length();
        String decoded = "";
        int  index = 0;
        while (index < length) {
            String ch = String.valueOf(input.charAt(index++));
            String countString = "";
            while (index < length && Character.isDigit(input.charAt(index))) {
                countString += input.charAt(index++);
            }
            int count = Integer.parseInt(countString);
            decoded += ch.repeat(count + 1);
        }
        return decoded;
    }
}
