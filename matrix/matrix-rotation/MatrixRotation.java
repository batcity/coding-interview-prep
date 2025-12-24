// https://leetcode.com/problems/rotate-image/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public void rotate(int[][] matrix) {

        // Alright - it seems like the solution is to traspose the matrix - then reverse the rows
        // I don't quite understand what reversing rows mean

        // but transposing the matrix is basically -> rows become columns and columns become rows

        int size = matrix.length;

        // traspose the matrix
        for(int i=0;i<size;i++) {
            // TODO: figure out why this starts at i+1
            for(int j=i+1;j<size;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }   
        }
    }
}