package Problems.String;

import Common.Problem;

public class MinDeletionsInsertionsToTransformStringToAnother extends Problem {
    @Override
    public void run() {
        System.out.println("Running Minimum Deletions And Insertions Required To Transform String To Another");
        String[] input = new String[]{"ZXVVYZW", "XKYKZPW", "passport", "ppsspt", "XZ", "ZX"};
        this.execute(input);
    }

    private void execute(String[] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            System.out.println("String 1: " + input[i]);
            System.out.println("String 2: " + input[i+1]);
            int[] delIns = this.minDeletionsAndInsertions(input[i], input[i+1]);
            System.out.println("Min Deletions: " + delIns[0]);
            System.out.println("Min Insertions: " + delIns[1]);
        }
    }

    private int[] minDeletionsAndInsertions(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 == 0) return new int[]{0, len2};
        if (len2 == 0) return new int[]{len1, 0};
        int maxLength = 0;
        int[] prev = new int[len2+1];
        for (int i = 1; i <= len1; i++) {
            int[] mem = new int[len2+1];
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    mem[j] = 1 + prev[j-1];
                } else {
                    mem[j] = Math.max(mem[j-1], prev[j]);
                }
                maxLength = Math.max(maxLength, mem[j]);
            }
            prev = mem;
        }
        int deletions = len1 - maxLength;
        int insertions = len2 - maxLength;
        return new int[]{deletions, insertions};
    }
}
