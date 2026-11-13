// https://leetcode.com/problems/design-add-and-search-words-data-structure/?envType=study-plan-v2&envId=top-interview-150
// TODO: optimize this

class WordDictionary {

    private Node root;
    private class Node {

        HashMap<Character, Node> children = new HashMap<>();
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
        // IO.println("current letter I'm looking at: " + letter);
        depth = depth + 1;
        boolean returnVal = false;

        if(letter == '.') {
            for(Node childNode: node.children.values()) {

                if(depth == len && childNode.wordEnd) { return true;}

                if(dfs(word, depth, childNode)) { return true;}
            }
        } else if(node.children.keySet().contains(letter)) {
            Node childNode = node.children.get(letter);
            if(depth == len && childNode.wordEnd) { return true;}
            returnVal = dfs(word, depth, childNode);
        }

        return returnVal;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
