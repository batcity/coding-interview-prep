// https://leetcode.com/problems/sum-root-to-leaf-numbers/?envType=study-plan-v2&envId=top-interview-150
// Time complexity: O(N) where N is the number of nodes in the tree
// Space complexity: O(H) where H is the height of the tree (used by the recursion stack)

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
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }


    public int dfs(TreeNode root, int currentSum) {
        if (root == null) {
            return 0;
        }

        currentSum = currentSum * 10 + root.val;

        if (root.left == null && root.right == null) {
            return currentSum;
        } 

        return dfs(root.left, currentSum) + dfs(root.right, currentSum);
    }
}