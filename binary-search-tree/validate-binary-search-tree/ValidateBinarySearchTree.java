// https://leetcode.com/problems/validate-binary-search-tree/?envType=study-plan-v2&envId=top-interview-150
// Time complexity: O(N)
// Space complexity: O(H) - this is the recursion stack

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

    public boolean isValidBST(TreeNode root) {

        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, Long min, Long max) {

        if(root==null) return true;

        if(root.val<=min || root.val>=max) return false;

        return isValid(root.left, min, Long.valueOf(root.val)) && isValid(root.right, Long.valueOf(root.val), max);
    }
}