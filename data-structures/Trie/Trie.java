import java.util.*;

class Trie {

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord = false;
    }

    public Trie() {
        TrieNode root = new TrieNode();
    }
    
    public void insert(String word) {
        for(Character char: word) {
          
        }
    }
    
    public boolean search(String word) {
        
    }
    
    public boolean startsWith(String prefix) {
        
    }
    
    public static void main() {
      Trie obj = new Trie();
      
    }
}