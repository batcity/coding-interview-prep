// https://leetcode.com/problems/minimum-absolute-difference-in-bst/?envType=study-plan-v2&envId=top-interview-150

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int getMinimumDifference(TreeNode root) {

        // simple approach is to make a queue of all the nodes in the BST
        // then compare each value with prev value in the queue and get the min
        // but that's two iterations, I'm trying to figure out if there's a way to do this with one iteration
        // no - I doubt it


        Queue<Integer> inorderQueue = new LinkedList<>()

        // previous bad solution
        // if(root == null) {
        //     return Integer.MAX_VALUE;
        // }

        
        // int leftDiff = Integer.MAX_VALUE;
        // int rightDiff = Integer.MAX_VALUE;

        // if(root.left != null) {
        //     leftDiff = root.val - root.left.val;
        // }

        // if(root.right != null) {
        //     rightDiff = root.right.val - root.val;
        // }

        // int currMin = Math.min(leftDiff, rightDiff);
        // int min = Math.min(currMin, Math.min(getMinimumDifference(root.left), getMinimumDifference(root.right)));
        // return min;
    }
}