# https://leetcode.com/problems/binary-tree-right-side-view/?envType=study-plan-v2&envId=top-interview-150

from collections import deque

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode | None) -> list[int]:
        return self.levelOrderTraversal(root)
    # so idea is get a bunch of levels together and pick the rightmost element in each level


    def levelOrderTraversal(self, root: TreeNode):

        outputArr: list[int] = []
        tempQueue = deque()
        tempQueue.append(root)
        index = 0
        if(root == None): return []
        num = root.val
        outputArr.append(num)

        while(len(tempQueue) > 0):

            currLevelSize = len(tempQueue)

            while(currLevelSize > 0):

                curr = tempQueue.popleft()

                if curr.left: 
                    left = curr.left
                    tempQueue.append(left)
                    num = left.val
                if curr.right:
                    right = curr.right
                    tempQueue.append(right)
                    num = right.val 

                currLevelSize = currLevelSize - 1
                if currLevelSize == 0: outputArr.append(num)

        
        return outputArr
