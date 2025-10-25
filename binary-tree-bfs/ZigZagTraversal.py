# https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/?envType=study-plan-v2&envId=top-interview-150

from typing import List, Optional
from collections import deque

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
        
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:

        if not root:
            return []
        
        node_queue = deque([root])
        output = []
        reverse = False

        while node_queue:
            node_queue_size = len(node_queue)
            temp_level_arr = []

            for i in range(node_queue_size):
                if reverse: 
                    node = node_queue.pop()
                else:
                    node = node_queue.popleft()

                if reverse: 
                    if node.right: 
                            node_queue.appendleft(node.right)
                    if node.left:
                            node_queue.appendleft(node.left)
                else:
                    if node.left:
                            node_queue.append(node.left)
                    if node.right:  
                            node_queue.append(node.right)

                temp_level_arr.append(node.val)

            output.append(temp_level_arr)
            reverse = not reverse

        return output