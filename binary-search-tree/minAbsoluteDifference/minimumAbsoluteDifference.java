// https://leetcode.com/problems/minimum-absolute-difference-in-bst/?envType=study-plan-v2&envId=top-interview-150
// Time complexity of the Solution = O(N) since we traverse the all the nodes in the tree once
// Space Complexity of the Solution = O(H), where H is the height of the tree

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

    private int minDiff = Integer.MAX_VALUE;
    private int prev = -1;

    public int getMinimumDifference(TreeNode root) {

        traverseTreeInOrder(root);
        return minDiff;
    }

    private void traverseTreeInOrder(TreeNode root) {

        if(root == null) {
            return;
        }

        traverseTreeInOrder(root.left);
        int currentVal = root.val;
        if(prev!=-1) {
            int diff = currentVal - prev;

            if(diff < minDiff) {
                minDiff = diff;
            }
        }
        prev = currentVal;
        traverseTreeInOrder(root.right);
        return;
    }
}