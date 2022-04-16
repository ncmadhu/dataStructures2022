package Problems.Trie;

import Common.Problem;

import java.util.ArrayList;
import java.util.Arrays;

public class FindAllTheWordsStartsWith extends Problem {
    @Override
    public void run() {
        System.out.println("Running Find All the words starts with in Trie");
        Trie trie;
        String words[];
        String startsWith;
        words = new String[]{"the", "th", "abcd", "abc", "any", "poor", "answer", "and"};
        trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            System.out.println("Inserting : " + words[i]);
            trie.insert(words[i]);
        }
        startsWith = "an";
        System.out.println("Words Inserted: " + Arrays.toString(words));
        System.out.println("Words Start With " + startsWith + " in Trie : " + this.findWordsStartsWith(trie, startsWith));
        startsWith = "anr";
        System.out.println("Words Inserted: " + Arrays.toString(words));
        System.out.println("Words Start With " + startsWith + " in Trie : " + this.findWordsStartsWith(trie, startsWith));
    }

    private ArrayList<String> findWordsStartsWith(Trie trie, String startsWith) {
        ArrayList<String> words = new ArrayList<>();
        TrieNode currentNode = trie.root;
        for (int i = 0; i < startsWith.length(); i++) {
            char ch =  startsWith.charAt(i);
            int index = trie.getIndex(ch);
            if (currentNode.children[index] == null) {
                currentNode = null;
                break;
            }
            currentNode = currentNode.children[index];
        }
        if (currentNode != null) this.getWords(currentNode, words, startsWith);
        return words;
    }

    public void getWords(TrieNode node, ArrayList<String> words, String word) {
        if (node == null) return;
        if (node.isEndOfWord()) words.add(word);
        for (int i = 0; i < 26; i++) {
            TrieNode child = node.children[i];
            if (child != null) {
                char ch = (char)('a' + i);
                this.getWords(child, words, word + ch);
            }
        }
    }
}
