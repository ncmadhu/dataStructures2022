package Algorithms.Trie;

import Algorithms.Algorithms;

import java.util.Arrays;

public class WordFormation extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Word Formation Using Trie");
        String word;
        String dict[];
        word = "helloworld";
        dict = new String[]{"the", "there", "hello", "world", "any", "poor"};
        System.out.println(word + " Possible: " + this.isFormationPossible(dict, word));
        word = "therepoor";
        System.out.println(word + " Possible: " + this.isFormationPossible(dict, word));
    }

    private boolean isFormationPossibleMy(String[] dict, String word) {
        Trie trie = new Trie();
        for (int i = 0; i < dict.length; i++) {
            System.out.println("Inserting : " + dict[i]);
            trie.insert(dict[i]);
        }
        System.out.println("Words Inserted: " + Arrays.toString(dict));
        TrieNode currNode = trie.root;
        int endOfWordIndex = 0;
        boolean endOfWordInPath = false;
        for(int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);
            int index = trie.getIndex(ch);
            if (currNode.children[index] != null) {
                currNode = currNode.children[index];
                if (currNode.isEndOfWord()) {
                    endOfWordIndex = i;
                    endOfWordInPath = true;
                }
            } else if (endOfWordInPath) {
                currNode = trie.root;
                i = endOfWordIndex;
                endOfWordInPath = false;
            }
            else {
                return  false;
            }
        }
        return currNode.isEndOfWord;
    }

    // Better Solution
    // Try searching trie for each substring combination pair
    public boolean isFormationPossible(String[] dict, String word) {
        if (word.length() < 2 || dict.length < 2) return false;
        Trie trie = new Trie();
        for (int i = 0; i < dict.length; i++) {
            System.out.println("Inserting : " + dict[i]);
            trie.insert(dict[i]);
        }
        System.out.println("Words Inserted: " + Arrays.toString(dict));
        for (int i = 0; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i, word.length());
            if (trie.search(prefix) && trie.search(suffix)) return true;
        }
        return false;
    }
}
