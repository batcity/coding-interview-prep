"""
# Definition for a QuadTree node.
class Node:
    def __init__(self, val, isLeaf, topLeft, topRight, bottomLeft, bottomRight):
        self.val = val
        self.isLeaf = isLeaf
        self.topLeft = topLeft
        self.topRight = topRight
        self.bottomLeft = bottomLeft
        self.bottomRight = bottomRight
"""

class Solution:

    def construct_quad_tree(self, grid: List[List[int]], start, end, size):

        if size == 1:
            return Node(grid[start][end], True, None, None, None, None)

        topLeft = self.construct_quad_tree(grid, start, start, size/2)
        topRight = self.construct_quad_tree(grid, start, start + size, size/2)
        bottomLeft = self.construct_quad_tree(grid, start + size, start, size/2)
        bottomRight = self.construct_quad_tree(grid, size, size, size/2)


        if topLeft.val == topRight.val == bottomlLeft.val == bottomRight.val:
            return Node(grid[start][end], true, None, None, None, None)

        return Node(grid[start][size], False, topLeft, topRight, bottomLeft, bottomRight)

    def construct(self, grid: List[List[int]]) -> 'Node':

        start = 0
        end = len(grid) - 1
        return self.construct_quad_tree(grid, start, end, len(grid))