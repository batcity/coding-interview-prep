// leetcode: https://leetcode.com/problems/snakes-and-ladders/?envType=study-plan-v2&envId=top-interview-150

import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        
        int n = board.length;
        int[] start = {n-1, 0};
        int[] destination = {0,0};


        // brute force approach is to begin at start position
        // go to every possible next position from the start and
        // repeat by going to every possible next position from the new start
        // record the number of moves for each path, find the min path and you should be good - that's the result

        // to figure out: how do I change directions when i get to end of current row
        return -1;
    }
}