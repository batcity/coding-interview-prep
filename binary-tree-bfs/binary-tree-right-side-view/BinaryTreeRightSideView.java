// https://leetcode.com/problems/binary-tree-right-side-view/?envType=study-plan-v2&envId=top-interview-150

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
    public List<Integer> rightSideView(TreeNode root) {

        var output = levelOrderTraversal(root);
        return output;
    }

    private ArrayList<Integer> levelOrderTraversal(TreeNode root) {
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        var output = new ArrayList<Integer>();
        queue.add(root);

        while(queue.size()!=0) {

            int currLevelLength = queue.size();
            Integer rightMostElement = null;

            while(currLevelLength > 0) {

                TreeNode currNode = queue.poll();
                currLevelLength--;

                if(currNode!=null) {
                    rightMostElement = currNode.val;
                } else {
                    continue;
                }

                if(currNode.left!=null) {
                    queue.add(currNode.left);
                }

                if(currNode.right!=null) {
                    queue.add(currNode.right);
                }
            }

            if(rightMostElement!=null) {
                output.add(rightMostElement);
            }
        }

        return output;
    }
}