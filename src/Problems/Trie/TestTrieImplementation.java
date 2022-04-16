package Problems.Trie;

import Common.Problem;

public class TestTrieImplementation extends Problem {
    @Override
    public void run() {
        System.out.println("Running Test Trie Implementation");
        Trie trie;
        String words[];
        String unknown[];
        String delete[];
        /*
        words = new String[]{"the", "a", "there", "answer", "any",
                "by", "bye", "theirs","abc", "abcd"};
        unknown = new String[]{"unknown", "abcde", "these", "their"};
        delete = new String[]{"th", "a", "there", "answer", "by", "abc"};
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            System.out.println("Inserting : " + words[i]);
            trie.insert(words[i]);
        }
        for (int i = 0; i < words.length; i++) {
            System.out.println("Searching : " + words[i]);
            System.out.println("Found: " + trie.search(words[i]));
        }
        for (int i = 0; i < unknown.length; i++) {
            System.out.println("Searching : " + unknown[i]);
            System.out.println("Found: " + trie.search(unknown[i]));
        }
        for (int i = 0; i < delete.length; i++) {
            System.out.println("Deleting : " + delete[i]);
            trie.delete(delete[i]);
        }

        for (int i = 0; i < words.length; i++) {
            System.out.println("Searching : " + words[i]);
            System.out.println("Found: " + trie.search(words[i]));
        }

         */

        words = new String[]{"the", "th", "abcd", "abc", "any", "poor"};
        unknown = new String[]{"unknown", "abcde", "the", "th", "abc", "any"};
        delete = new String[]{"the", "a", "abc", "poor"};
        trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            System.out.println("Inserting : " + words[i]);
            trie.insert(words[i]);
        }
        for (int i = 0; i < words.length; i++) {
            System.out.println("Searching : " + unknown[i]);
            System.out.println("Found: " + trie.search(unknown[i]));
        }
        for (int i = 0; i < delete.length; i++) {
            System.out.println("Deleting : " + delete[i]);
            trie.delete(delete[i]);
        }
        for (int i = 0; i < words.length; i++) {
            System.out.println("Searching : " + words[i]);
            System.out.println("Found: " + trie.search(words[i]));
        }
    }
}
