package Algorithms.String;

import Algorithms.Algorithms;

public class ReverseString extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Reverse String");
        char[] input;
        input = new char[]{'h','e','l','l','o'};
        System.out.println("Input: " + new String(input));
        reverseString(input);
        System.out.println("Output: " + new String(input));
        input = new char[]{'H','a','n','n','a','h'};
        System.out.println("Input: " + new String(input));
        reverseString(input);
        System.out.println("Output: " + new String(input));
        input = new char[]{'m','a','l','a','y','a','l','a','m'};
        System.out.println("Input: " + new String(input));
        reverseString(input);
        System.out.println("Output: " + new String(input));
    }
    public void reverseString(char[] s) {
        int length = s.length;
        for(int i=0; i<length/2; i++) {
            char temp = s[i];
            s[i] = s[length - 1 - i];
            s[length - 1 - i] = temp;
        }
    }

}
