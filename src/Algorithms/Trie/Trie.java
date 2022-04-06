package Algorithms.Trie;

import java.util.ArrayList;

public class Trie {
    // Root node representing *
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    // Method to get index of Character in the Children array
    // 'a' is considered 0. index is distance from a
    public int getIndex(char c) {
        return c - 'a';
    }

    // Insert a new word
    // Iterate over each character in the word
    // Determine the index of the character (distance from a)
    // check whether character already exists in the current trie node children array at that index
    // If present make that as current node
    // If not present , create a new trie node and update the value of children array at that index
    // make the new node as current node
    // After the loop exited, mark the end of word at the current node
    public void insert(String word) {
        if (word == null) return;
        char c;
        int index;
        int length = word.length();
        TrieNode currentNode = this.root;
        word = word.toLowerCase(); // convert word to lower case
        for (int level = 0; level < length; level++) {
            c = word.charAt(level);
            index = this.getIndex(c);
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
        }
        currentNode.setEndOfWord(true);
    }
    // Search for a word
    // Iterate over each character in the word
    // Determine the index of the character (distance from a)
    // check whether node at the index in trie node children array is not null
    // If null the word is not present in the trie, return false
    // If present, make the value as the current trie node
    // After exiting the loop check whether the endOfWord is true and return the value
    public boolean search(String word) {
        if (word == null) return false;
        char c;
        int index;
        int length = word.length();
        word = word.toLowerCase(); // convert word to lower case
        TrieNode currentNode = this.root;
        for (int level = 0; level < word.length(); level++) {
            c = word.charAt(level);
            index = this.getIndex(c);
            if (currentNode.children[index] == null) return false;
            currentNode = currentNode.children[index];
        }
        return currentNode.isEndOfWord();
    }

    // Check whether TrieNode has children
    public boolean hasNoChildren(TrieNode node) {
        boolean hasNoChildren = true;
        for (TrieNode child : node.children) {
            if (child != null) {
                hasNoChildren = false;
                break;
            }
        }
        return hasNoChildren;
    }
    // Delete a Word (Recursion is needed since backtracking cleans up the empty branches)
    // Start recursion to delete with root node, word to be deleted and level starting with 0
    // In delete method
    //      Fetch the character at given level
    //      Determine the index of the character (distance from a)
    //      Check whether character exists in the Trie children if not return the node
    //      If character exists, check whether length of word is reached if not call delete again with
    //      character Trie node with level increased
    //      If length of word is reached, check whether character Trie node has no children
    //      If no children present mark the character index position as null in the Trie node
    //      If children present update the end of word as false
    //      return the node
    // During backtracking nodes uplevel cleanup themselves if no children present because of children deleted
    // if the node is not end of word otherwise

    public void delete(String word) {
        if (word == null || this.root == null) return;
        this.delete(this.root, word, 0, word.length());
    }

    public TrieNode deleteInEfficient(TrieNode node, String word, int level, int length) {
        char c = word.charAt(level);
        int index = this.getIndex(c);
        if (level < length - 1 && node.children[index] != null) {
            node.children[index] = this.deleteInEfficient(node.children[index], word, level + 1, length);
        }
        TrieNode childNode = node.children[index];
        if (childNode != null) {
            if (this.hasNoChildren(childNode)) {
                childNode = null;
            } else if (level == length - 1) {
                childNode.setEndOfWord(false);
            }
            node.children[index] = childNode;
        }
        return node;
    }

    public TrieNode delete(TrieNode node, String word, int level, int length) {
        if (level == length) {
            if (this.hasNoChildren(node)) {
                node = null;
            } else {
                node.setEndOfWord(false);
            }
        } else {
            char ch = word.charAt(level);
            int index = this.getIndex(ch);
            if (node.children[index] != null) {
                node.children[index] = this.delete(node.children[index], word, level + 1, length);
                // Check for end of word before cleaning up, otherwise we may delete end fo word with no children
                // also accidentally
                if (!node.isEndOfWord() && this.hasNoChildren(node)) {
                    node = null;
                }
            }
        }
        return node;
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
