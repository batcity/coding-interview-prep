# https://leetcode.com/problems/rotate-image/?envType=study-plan-v2&envId=top-interview-150
# Time complexity: O(n*n) since the matrix is n*n
# Space complexity: O(1) since we're not using any additional space

class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        # this one's more of a matrix trick
        # what one needs to do is convert the columns to rows, then reverse the rows

        self.convert_columns_to_rows(matrix)
        self.reverse_list(matrix)
    
    def convert_columns_to_rows(self, matrix: List[List[int]]):

        # The trick is to only swap elements in the upper right triangle
        size = len(matrix)
        x = 0

        while(x<size):
            y = x + 1
            while(y<size):
                matrix[x][y], matrix[y][x] = matrix[y][x], matrix[x][y]
                y = y + 1
            
            x = x + 1

    def reverse_list(self, matrix: List[List[int]]):

        for currList in matrix:
            currList.reverse()