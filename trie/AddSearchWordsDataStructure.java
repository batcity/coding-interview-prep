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
        if(depth >= len) return false;
        depth = depth + 1;
        letter = word.charAt(depth);

        if(letter == '.') {

            boolean returnVal = false;

            for(Node childNode: node.children) {
                returnVal = returnVal || dfs(word, depth, childNode);
            }

            return returnVal;
        }

        
        boolean returnVal = false;
        for(Node childNode: node.children) {
            if(childNode.val == letter) returnVal = returnVal || dfs(childNode);
        }
        return returnVal.wordEnd;
    }

    private List<Node> searchChildren(List<Node> nodesToSearch, Character val) {
        
        for(Node node: nodesToSearch) {
            if(node.children.containsKey(val)) {
                return List.of(node.children.get(val));
            }
        }

        return List.of();
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
