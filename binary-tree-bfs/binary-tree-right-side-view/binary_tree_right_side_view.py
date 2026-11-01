# https://leetcode.com/problems/binary-tree-right-side-view/?envType=study-plan-v2&envId=top-interview-150

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode | None) -> list[int]:
    # so idea is get a bunch of levels together and pick the rightmost element in each level


    def levelOrderTraversal(self, root: TreeNode):

        int currLevelSize = 1
        int[][] outputArr = {}
        tempQueue = {}
        int index = 0

        while(tempQueue.length > 0):

            while(currLevelSize > 0):
                if root.left: tempQueue.add(root.left)
                if root.right: tempQueue.add(root.right)

            outputArr.add()
