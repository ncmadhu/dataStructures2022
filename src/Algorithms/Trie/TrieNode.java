package Algorithms.Trie;

public class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    static final int ALPHABET_SIZE = 26;

    public TrieNode() {
        this.children = new TrieNode[ALPHABET_SIZE];
        this.isEndOfWord = false;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }
}
