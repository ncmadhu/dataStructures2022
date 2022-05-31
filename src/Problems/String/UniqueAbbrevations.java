package Problems.String;

import Common.Problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UniqueAbbrevations extends Problem {
    @Override
    public void run() {
        System.out.println("Running Unique Abbrevations");
        String[] input = new String[]{"AB", "BAT", "CODE"};
        this.execute(input);
    }

    private void execute(String[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + input[i]);
            System.out.println("Output: " + this.uniqueAbbrevations(input[i]));
        }
    }
    private class Abbrevation {
        String str;
        int pos;
        int count;

        public Abbrevation(String s, int pos, int count) {
            this.str = s;
            this.pos = pos;
            this.count = count;
        }
    }
    private List<String> uniqueAbbrevations(String str) {
        List<String> result = new ArrayList<>();
        int length = str.length();
        if (length == 0) return result;
        Queue<Abbrevation> queue = new LinkedList<>();
        queue.add(new Abbrevation("", 0, 0));
        while (!queue.isEmpty()) {
            Abbrevation abbr = queue.poll();
            String s = abbr.str;
            if (abbr.pos == length) {
                if (abbr.count != 0) s = s + abbr.count;
                result.add(s);
            } else {
                queue.add(new Abbrevation(s, abbr.pos + 1, abbr.count + 1));
                if (abbr.count != 0) s = s + abbr.count;
                queue.add(new Abbrevation(s + str.charAt(abbr.pos),
                        abbr.pos + 1, 0));
            }
        }
        return result;
    }
}
