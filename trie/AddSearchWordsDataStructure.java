// https://leetcode.com/problems/design-add-and-search-words-data-structure/?envType=study-plan-v2&envId=top-interview-150

class WordDictionary {

    private Node root;
    private class Node {

        Character val;
        HashMap<Character, Node> children;
        boolean wordEnd;

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
                currentNode = newNode;
            }
        }

        currentNode.wordEnd = true;
    }
    
    public boolean search(String word) {
        List<Node> nodesToSearch = List.of(root);

        for(char letter: word.toCharArray()) {

            if(letter == '.') {

                var newNodesToSearch = new ArrayList<Node>();

                for(Node node: nodesToSearch) {
                    newNodesToSearch.addAll(node.children.values());
                }

                nodesToSearch = newNodesToSearch;

                continue;
            }

            nodesToSearch = searchChildren(nodesToSearch, letter);

            if(nodesToSearch.size()==0) return false;
        }

        if(nodesToSearch.size()==0) return false;
        Node currentNode = nodesToSearch.get(0);
        if(!currentNode.wordEnd) return false;

        return true;
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