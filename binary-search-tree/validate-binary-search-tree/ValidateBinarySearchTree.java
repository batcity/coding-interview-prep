// https://leetcode.com/problems/validate-binary-search-tree/?envType=study-plan-v2&envId=top-interview-150

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

        return inOrderTraversal(root, null);
    }

    private boolean inOrderTraversal(TreeNode root, TreeNode prev) {

        if(root == null) return true;

        if(prev!=null && prev.val>=root.val) return false;

        boolean isLeftSubtreeValid = inOrderTraversal(root.left, prev);
        prev = root;
        boolean isRightSubtreeValid = inOrderTraversal(root.right, prev);

        if(isLeftSubtreeValid && isRightSubtreeValid) {
            return true;
        }

        return false;
    }
}