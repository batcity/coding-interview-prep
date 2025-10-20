/*
//Question: https://leetcode.com/problems/construct-quad-tree/?envType=study-plan-v2&envId=top-interview-150

// Definition for a QuadTree node.
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
*/

class Solution {
    public Node construct(int[][] grid) {
        int size = grid.length;
        return build(grid, 0, 0, size);
    }

    private Node build(int[][] grid, int rowStart, int colStart, int size) {

        if(size == 1) {
            boolean val = false;
            if(grid[rowStart][colStart] == 1) {
                val = true;
            }

            return new Node(val, true);
        }

        int half = size/2;
        Node topLeft = build(grid, rowStart, colStart, half);
        Node topRight = build(grid, rowStart, colStart+half, half);
        Node bottomLeft = build(grid, rowStart+half, colStart, half);
        Node bottomRight = build(grid, rowStart+half, colStart+half, half);

        
        if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf 
        && topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true);
        }

        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}