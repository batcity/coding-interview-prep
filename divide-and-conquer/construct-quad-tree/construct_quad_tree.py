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
    def construct(self, grid: List[List[int]]) -> 'Node':

        start = 0
        end = grid.length - 1
        return constructQuadTree(start, end)
        

    def constructQuadTree(self, grid: List[List[int]], start, end):

        # how do i figure out if the value is just one element
        # actually each sub quad tree should be a middle point of that tree

        # refine this line
        Node topLeft = constructQuadTree(self, grid, end/2/2, end/2/2)

        # these start and end pionts are incorrect
        Node topRight = constructQuadTree(self, grid, start, end)
        Node bottomLeft = constructQuadTree(self, grid, end, start)
        Node bottomRight = constructQuadTree(self, grid, end, end)