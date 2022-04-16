package Problems.Trie;

import Common.Problem;

import java.util.ArrayList;
import java.util.Arrays;

public class FindAllTheWords extends Problem {
    @Override
    public void run() {
        System.out.println("Running Find All the words in Trie");
        Trie trie;
        String words[];
        words = new String[]{"the", "th", "abcd", "abc", "any", "poor"};
        trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            System.out.println("Inserting : " + words[i]);
            trie.insert(words[i]);
        }
        System.out.println("Words Inserted: " + Arrays.toString(words));
        System.out.println("Words in Trie : " + this.findWords(trie.root));
    }

    private ArrayList<String> findWords(TrieNode root) {
        ArrayList<String> words = new ArrayList<>();
        this.getWords(root, words, "");
        return words;
    }

    private void getWords(TrieNode node, ArrayList<String> words, String result) {
        if (node == null) return;
        if (node.isEndOfWord()) words.add(result);
        for (int i = 0; i < 26; i++) {
            TrieNode child = node.children[i];
            if (child != null) {
                char ch = (char)('a' + i);
                this.getWords(child, words, result + ch);
            }
        }
    }
}
