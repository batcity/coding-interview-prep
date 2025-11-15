# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def __init__(self):
        self.prev_val = None
        self.min_diff = float("inf")

    def in_order_traversal(self, root: TreeNode):

        if root is None:
            return

        self.in_order_traversal(root.left)

        if self.prev_val is not None and (root.val - self.prev_val) < self.min_diff:
            self.min_diff = root.val - self.prev_val

        self.prev_val = root.val

        self.in_order_traversal(root.right)

    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        self.in_order_traversal(root)
        return self.min_diff