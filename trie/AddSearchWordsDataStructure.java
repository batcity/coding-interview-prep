// https://leetcode.com/problems/design-add-and-search-words-data-structure/?envType=study-plan-v2&envId=top-interview-150

class WordDictionary {

    private Node root;
    private class Node {

        HashMap<Character, Node> children;
        boolean wordEnd = false;
    }

    public WordDictionary() {
        this.root = new Node();
    }
    
    public void addWord(String word) {

        Node currentNode = root;

        for(char letter: word.toCharArray()) {
            if(currentNode.children.keySet().contains(letter)) {
                currentNode = currentNode.children.get(letter);
            } else {
                Node newNode = new Node();
                currentNode.children.put(letter, newNode);
                currentNode = newNode;
            }
        }

        currentNode.wordEnd = true;
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int depth, Node node) {
        
        int len = word.length();
        // Base case
        if(depth >= len) return false;

        char letter = word.charAt(depth);
        depth = depth + 1;
        boolean returnVal = false;

        if(letter == '.') {

            for(Node childNode: node.children.values()) {
                returnVal = returnVal || dfs(word, depth, childNode);
                if(returnVal) return true;
            }

            return false;
        }

        for(Node childNode: node.children.values()) {
            if(childNode.val == letter) {

                if(depth == len && childNode.wordEnd) { return true;}
                returnVal = dfs(childNode);
            }
            if(returnVal) return true;
        }

        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
