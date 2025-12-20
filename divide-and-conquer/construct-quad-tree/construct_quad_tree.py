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

    def construct_quad_tree(self, grid: List[List[int]], row_start: int, column_start: int, size):

        if size == 1:
            val = False
            if grid[row_start][column_start]==1:
                val = True
                
            return Node(val, True, None, None, None, None)

        half = int(size/2)
        topLeft = self.construct_quad_tree(grid, row_start, column_start, half)
        topRight = self.construct_quad_tree(grid, row_start, column_start+half, half)
        bottomLeft = self.construct_quad_tree(grid, row_start+half, column_start, half)
        bottomRight = self.construct_quad_tree(grid, row_start+half, column_start+half, half)
        
        if (
            topLeft.isLeaf and topRight.isLeaf and
            bottomLeft.isLeaf and bottomRight.isLeaf and
            topLeft.val == topRight.val == bottomLeft.val == bottomRight.val
        ):
            return Node(topLeft.val, True, None, None, None, None)

        return Node(True, False, topLeft, topRight, bottomLeft, bottomRight)

    def construct(self, grid: List[List[int]]) -> 'Node':

        row_start = 0
        column_start = 0
        return self.construct_quad_tree(grid, row_start, column_start, len(grid))