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

        int index = start;
        int current = start;

        while(index < n) {

            if(index % 2 == 0) {
                for()
            }
        }

        return -1;
    }
}