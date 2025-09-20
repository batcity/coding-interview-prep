// leetcode: https://leetcode.com/problems/snakes-and-ladders/?envType=study-plan-v2&envId=top-interview-150

import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        
        int n = board.length;
        int[] start = {n-1, 0};
        int[] destination = {0,0};

        System.out.println(board[start[0]][start[1]]);


        // 1. brute force approach is to begin at start position
        // 2. go to every possible next position from the start and
        // 3. pick the maximum that's closest to the destination - name this as current position - increse stp count by 1
        // 4. repeat by going to every possible next position from the current position
        // 5. if you land at the end from the current position - increase the step count by 1 - that's your result

        // to figure out: 
        // - how do I change directions when i get to end of current row
        // - how do I figure out what position "15" or "35" is with respect to the matrix


        // ideal thing is I need a way to translate from position to slot in the matrix
        // 1 -> 5,0 - that type of thing but this seems matematically not possible lol
        // easier way is to just maintain both and just figure out a way to increment the matrix slot
        return -1;
    }

    // the array this returns should be the new end poition on the matrix
    int[] moveToPosition(int boardPosition, int x, int y, int numOfMoves) {
        
    }
}