# https://leetcode.com/problems/sum-root-to-leaf-numbers/?envType=study-plan-v2&envId=top-interview-150
# Time complexity: O(N) where N is the number of nodes in the tree
# Space complexity: O(H) where H is the height of the tree (call stack space btw)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def sumNumbers(self, root: TreeNode | None) -> int:
        return self.sumNumber(root, 0)      

    def sumNumber(self, root:TreeNode, running_total: int):

        if(root==None): return 0

        running_total = running_total * 10 + root.val
        # print(f"{curr_string=}")

        if(root.left==None and root.right==None):
            return running_total

        return self.sumNumber(root.left, running_total) + self.sumNumber(root.right, running_total)
