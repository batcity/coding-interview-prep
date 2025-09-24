// leetcode: https://leetcode.com/problems/snakes-and-ladders/?envType=study-plan-v2&envId=top-interview-150

import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        
        int n = board.length;

        // step 1: flatten the board so I don't have to think about which direction to move
        // when I start BFS
        int start = 0;
        int destination = (n * n) - 1;

        int[] flattenedGraph = new int[n * n];

        int index = n-1;
        int flattenedGraphIndex = 0;
        boolean flip = false;

        while(index > -1) {

            if(flip) {
                for(int k=n-1; k>-1; k--) {
                    System.out.println("modifying: " + index + "," + k);
                    flattenedGraph[flattenedGraphIndex] = board[index][k];
                    flattenedGraphIndex++;
                }

                flip = false;
            } else {
                for(int c=0; c<n; c++) {
                    System.out.println("modifying: " + index + "," + c);
                    flattenedGraph[flattenedGraphIndex] = board[index][c];
                    flattenedGraphIndex++;
                }
                flip = true; 
            }
               
            index--;
        }

        // Arrays.stream(flattenedGraph).forEach(x -> System.out.println(x));

        return -1;
    }
}