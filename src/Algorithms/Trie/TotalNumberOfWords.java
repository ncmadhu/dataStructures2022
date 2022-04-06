package Algorithms.Trie;

import Algorithms.Algorithms;

import java.util.Arrays;

public class TotalNumberOfWords extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Total number of words in Trie");
        Trie trie;
        String words[];
        words = new String[]{"the", "th", "abcd", "abc", "any", "poor"};
        trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            System.out.println("Inserting : " + words[i]);
            trie.insert(words[i]);
        }
        System.out.println("Words Inserted: " + Arrays.toString(words));
        System.out.println("Total number of words in Trie : " + this.totalWords(trie.root));
    }

    private int totalWords(TrieNode root) {

        return this.countWords(root, 0);
    }

    private int countWords(TrieNode node, int count) {
        if (node == null) return count;
        // If node is end of word increase the count
        if (node.isEndOfWord()) count++;
        for (TrieNode child: node.children) {
            if (child != null) {
                count = this.countWords(child, count);
            }
        }
        return count;
    }
}
