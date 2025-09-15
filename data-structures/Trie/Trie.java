import java.util.*;

class Trie {

    TrieNode root;

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord = false;

        public TrieNode(boolean isEndOfWord) {
            children = new HashMap<>();
            this.isEndOfWord = isEndOfWord;
        }
    }

    public Trie() {
        root = new TrieNode(false);
    }
    
    public void insert(String word) {

        TrieNode tempRoot = root;
        int index = 0;

        for(Character element: word.toCharArray()) {

            index++;
            if(tempRoot.children.containsKey(element)) {
                tempRoot = tempRoot.children.get(element);
                continue;
            }

            tempRoot.children.put(element, new TrieNode(false));
            tempRoot = tempRoot.children.get(element);
        }

        tempRoot.isEndOfWord = true;
    }
    
    public boolean search(String word) {

        TrieNode tempRoot = root;

        for(Character element: word.toCharArray()) {

            if(tempRoot.children.containsKey(element)) {
                tempRoot = tempRoot.children.get(element);
                continue;
            } else {
                return false;
            }
        }

        if(!tempRoot.isEndOfWord) {
            return false;
        }

        return true;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode tempRoot = root;

        for(Character element: prefix.toCharArray()) {

            if(tempRoot.children.containsKey(element)) {
                tempRoot = tempRoot.children.get(element);
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
      Trie trie = new Trie();

      trie.insert("test");
      System.out.println(trie.search("test"));
      System.out.println(trie.search("tes"));
      System.out.println(trie.startsWith("tes"));
      System.out.println(trie.startsWith("app"));
      trie.insert("apple");
      trie.insert("app");
      System.out.println(trie.search("app"));
    }
}