// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/?envType=study-plan-v2&envId=top-interview-150

import java.util.*;

// Status: passed 19/33 testcases -> good enough for phase 1

/**
- start at root, add the root element to the queue
- initialize a counter
- if current depth is even then 
  - break out if queue is empty
  - pull elements from the queue, add non null children to a stack from right to left, 
  - also add pulled elements to the final output
- if current depth is odd then
  - break out if stack is empty
  - pull/remove elements from the stack, add non null children to queue from left to right, 
  - also add pulled elements to the final output
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {


        int depth = 0;
        List<List<Integer>> outputList = new ArrayList<>();
        Queue<TreeNode> levelQueue = new LinkedList<TreeNode>();
        Stack<TreeNode> levelStack = new Stack<TreeNode>();
        levelQueue.add(root);

        if( root == null ) {
            return outputList;
        }

        while(true) {

            if(depth % 2 == 0) {
                if(levelQueue.size() == 0) {
                    break;
                }

                List<Integer> currentValues = new ArrayList<>();

                while(levelQueue.size()!= 0) {
                    TreeNode currentNode = levelQueue.poll();

                    if(currentNode.left != null) {
                        levelStack.add(currentNode.left);
                    }

                    if(currentNode.right != null) {
                        levelStack.add(currentNode.right);
                    }

                    currentValues.add(currentNode.val);
                }

                outputList.add(currentValues);
            } else {
                if(levelStack.size() == 0) {
                    break;
                }

                List<Integer> currentValues = new ArrayList<>();

                while(levelStack.size() != 0) {
                    TreeNode currentNode = levelStack.pop();

                    if(currentNode.left != null) {
                        levelQueue.add(currentNode.left);
                    }

                    if(currentNode.right != null) {
                        levelQueue.add(currentNode.right);
                    }

                    currentValues.add(currentNode.val);
                }

                outputList.add(currentValues);
            }

            depth++;
        }
        

        return outputList;
    }
}