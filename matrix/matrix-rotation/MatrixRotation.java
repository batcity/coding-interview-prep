// https://leetcode.com/problems/rotate-image/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public void rotate(int[][] matrix) {

        // Alright - it seems like the solution is to traspose the matrix, then reverse the rows

        int size = matrix.length;

        // transposing the matrix is basically -> rows become columns and columns become rows
        for(int i=0;i<size;i++) {
            for(int j=i+1;j<size;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }   
        }

        // reverse the rows
        for(int[] row: matrix) {
            int start = 0;
            int end = size-1;

            while(end > start) {
                int temp = row[end];
                row[end] = row[start];
                row[start] = temp;
                end--;
                start++;
            }
        }
    }
}