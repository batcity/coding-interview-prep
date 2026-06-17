// https://leetcode.com/problems/design-add-and-search-words-data-structure/?envType=study-plan-v2&envId=top-interview-150

import java.util.*;

class WordDictionary {

    private Node root;
    private class Node {

        Character val;
        HashMap<Character, Node> children;

        public Node(Character val, HashMap<Character, Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public WordDictionary() {
        this.root = new Node(null, new HashMap<Character, Node>());
    }
    
    public void addWord(String word) {

        Node currentNode = root;

        for(char letter: word.toCharArray()) {
            if(currentNode.children.keySet().contains(letter)) {
                currentNode = currentNode.children.get(letter);
            } else {
                Node newNode = new Node(letter, new HashMap<Character, Node>());
                currentNode.children.put(letter, newNode);
            }
        }
    }
    
    public boolean search(String word) {
        Node currentNode = root;

        for(char letter: word.toCharArray()) {
            searchChildren();
        }
    }

    private boolean searchChildren(Node node, character val) {

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */