/*
//Question: https://leetcode.com/problems/construct-quad-tree/?envType=study-plan-v2&envId=top-interview-150
// Definition for a QuadTree node.
*/

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

class Solution {
    public Node construct(int[][] grid) {

        // as a first step let me figure out how to break down a matrix into four subgrids
        // then i'll just have to recurse down the matrix -> makes sense

        int n = grid.length;
        System.out.println("matrix is a " + n + " by " + n + " matrix");


        // the first Node represents the entire matrix and is never a leaf ofcourse

        // This is the root node
        // I'm setting the val to false and isLeaf = false
        Node root = new Node(false, false);


        // things to think about
        // in this test case: [[0,0],[0,0]]
        // we return: [[1,0]] -> which means the Node is a leaf node where all values are zero -> but how can the root
        // node be a leaf node
        
        return null;
    }
}